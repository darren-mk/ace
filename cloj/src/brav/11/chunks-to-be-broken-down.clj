(require '[clojure.core.async :as a])

;; Chapter 11 Mastering Concurrent Processes with core.async
;; https://web.telegram.org/k/

;; process
;; is a "concurrently running unit of logic that responds to events".
;; e.g. 
(def echo-chan (chan)) ;; create a channel and assign it to variable
(go (println (<! echo-chan))) ;; waiting to take and print async
(>!! echo-chan "ketchup") ;; give a value to the channel and print takes place.

;; go
;; everything within a go expression runs concurrently on a separate thread.
;; go blocks run your processes on a thread pool that contains a number of threads,
;; which is equal to two pulus the number of cores on your machine.
;; your program does not need to create a new thread for each process.
;; this often results in better performance because you avoid the overhead,
;; which associates with creating threads.
;; you can create as many go processes as you want but cannot do with threads.

;; blocking

;; e.g. 
(def chan-for-blocking (chan)) 
(prn (<!! chan-for-blocking) " is taken from blocking.") .
(>!! chan-for-blocking "here the val")
;; DOES NOT WORK BECAUSE BLOCKING <!! DID NOT START IN THREAD!!!

;; e.g. 
(def chan-for-blocking (chan)) 
(prn (<!! chan-for-blocking) " is taken from blocking.") 
(thread (>!! chan-for-blocking "here the val"))
;; DOES NOT WORK BECAUSE BLOCKING <!! DID NOT START IN THREAD!!!

;; e.g.
(def chan-for-blocking (chan)) 
(thread (prn (<!! chan-for-blocking) " is taken from blocking.")) ;; blocked
(>!! chan-for-blocking "here the val") ;; released
;; works!
;; print "here the val" " is taken from blocking."

;; e.g.
(def chan-for-blocking (chan)) 
(thread (prn (<!! chan-for-blocking) " is taken from blocking."))
(thread (prn (<!! chan-for-blocking) " is also taken from blocking.")) 
(>!! chan-for-blocking "here the val") 
(>!! chan-for-blocking "here another val") 

;; parking 
(def chan-for-parking (chan)) ;; declare a channel
(take! chan-for-parking
       (fn [x] (prn x " is taken from parking.")))
;; start taking on parking, repl not blocked
(take! chan-for-parking
       (fn [x] (prn x " is taken from parking, again.")))
;; start taking on parking, repl not blocked
(put! chan-for-parking "here the val")
;; print "here the val" " is taken from parking."
(put! chan-for-parking "here another val")
;; print "here another val" " is taken from parking, again."
;; as parking does not block, you can spawn unlimited number of take and put. 
;; they are just parked somewhere blocking nobody but waiting for you.

;; thread
;; e.g.
(def c (chan))
(thread (prn (<!! c)))
(>!! c "mustard")
;; given in book
(def c (chan))
(go (prn (<! c)))
(>!! c "coke")
;; alteration using go instead of thread
;; works the same

;; hot dog machne example
(defn hot-dog-machine []
  (let [in (chan)
        out (chan)]
    (go (<! in)
        (>! out "hot dog"))
    [in out]))
(let [[in out] (hot-dog-machine)]
  (>!! in "pocket money")
  (<!! out)) ;; "hot dog"

;; self-made question:
;; create cider vending machine. 
;; when the machine initiates, the creator should give
;; the total number of cider cans and
;; price of one can. 
;; if inputted money is smaller no can and return money.
;; if higher just 1 can and return the residual.
(defn cider-vending-machine
  [stock price]
  (let [cash-inlet (a/chan)
        cash-vault (a/chan)
        can-dispenser (a/chan)]
    (a/go-loop [can-count stock]
      (if (> can-count 0)
        (let [inserted-cash (a/<! cash-inlet)]
          (if (< inserted-cash price)
                (do (prn "Money not enough.")
                    (recur can-count))
                (do (a/>! cash-inlet (- inserted-cash price))
                    (a/>! cash-vault price)
                    (a/>! can-dispenser "cider")
                    (recur (dec can-count)))))
        (do (prn "All cans are sold so the remaining # of cans is " can-count)
            (prn "Your revenue is " (<! cash-vault))
            (a/close! cash-inlet)
            (a/close! cash-vault)
            (a/close! can-dispenser))))
    [cash-inlet can-dispenser]))

(let [[in out] (cider-vending-machine 5 2.5)]
  (a/>!! in 2.5)
  (prn (a/<!! out)))

