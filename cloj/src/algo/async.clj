(require '[clojure.core.async :refer
           [chan >!! <!! <! >! put! timeout
            thread put! take! go close!]])

(def c1 (chan))
(thread (>!! c1 "abc"))
(thread (prn (<!! c1)))

(def c2 (chan))
(go (>! c2 "bcd"))
(go (prn (<! c1)))

(def c3 (chan))
(go (prn (<! c3)))
(go (>! c3 "bcd"))

(def c4 (chan))
(prn (<!! c4))
(>!! c4 "def")

(def c5 (chan))
(>!! c5 "xyz")
(prn (<!! c5))

;;;;; REPL ---------------------------------------------
;; by thread / go
;;;; another (next) channel ------------- waiting -------

(def c (chan))
(go (prn "put >! is done")
    (>! c 789))
(println (<!! c))

;;;;; REPL ---------------------------------------------
;; by thread / go
;;;; another (next) channel ------------- waiting -------

;; create a channel
(def c (chan))
;; run jetty server for high traffic job
(run-jetty "jobs of response to 1 million request per second")
;; appoint this job (reading BIG TEXT FILE) to an IDLE CPU or RESOURCE
(read-100gb-text-file "abc.txt")

(def c-server (chan))
(go (c-server (run-jetty ...)))

(def c-reading (chan))
(go (c-reading (read-100gb-text-file ...)))

(log ...)

(go (>! c (read-big-text-file-and-return "abc.txt")))

;; some resource -> being used by jetty
;; some other resource

;; c2
(def c2 (chan))
(thread (println (<!! c))) 
(>!! c 567) ;; put it!

;; c3
(def c3 (chan))
(>!! c3 567) ;; put it!
(thread (println (<!! c3))) ;; take it!

;; Ex2: Compose them so that in the last example you have one thread
;; continuously printing results from ch-resp instead of the inline
;; thread.

(defn printing [c]
  (thread
    (loop []
      (let [v (<!! c)]
        (when (some? v)          
          (prn "printed result is: " v)
          (recur))))
    (prn "thread closed.")))

(defn increasing [c]
  (thread
    (loop []
      (let [[v pc :as all] (<!! c)]
        (when (some? all)
          (prn "taken value is: " v)
          (put! pc (inc v))
          (recur))))
    (prn "thread closed.")))

(def value-channel (chan))
(increasing value-channel)

(def print-channel (chan))
(printing print-channel)

(put! value-channel [1 print-channel])

(close! value-channel)
(close! print-channel)

;; Ex3: Find out what happens when you have multiple threads consuming
;; a single channel (i. e. in the last example, spawn the
;; example-thread on c multiple times).  How would it be useful?

;; not sure if i understand the question correctly. 
;; but assuming there is a single channel,

(def kitchen-table (chan))

(thread (prn "customer 1 gets " (<!! kitchen-table)))

(go (prn "customer 1 gets " (<! kitchen-table))
    (prn "this will be blocked till ... "))

(go (prn "customer 2 gets " (<! kitchen-table)))
(go (prn "customer 3 gets " (<! kitchen-table)))

(defn cook-prepares-beer []
  (go (>! kitchen-table "beer")
      (prn "beer cooked!")
      ))

(cook-prepares-beer)

;; go, <!, >! - oh now i am comfortable
;; put!, take! -> any different?

(def cooking-table (chan))

(take! cooking-table (partial prn "customer 1 gets "))
(take! cooking-table (partial prn "customer 2 gets "))
(take! cooking-table (partial prn "customer 3 gets "))

(put! cooking-table "noodle")

;; 3 customers in a pub - take block
;; each has ordered beer
;; but there is one kitchen window plate, which can have one food/drink at once
;; cook is prepraring the drink



;; Ex4: Familiarize yourself with using "go".  For now, just treat it
;; as an alternative to "thread" in which you have to use >! and <!
;; instead of >!! and <!!

;; this is my challenge
;; it seems we have a few options, but i am not sure about the differences.
;; between `thread`, `go`, and else.




;; Ex5: You have two channels, and a single consumer thread.  The
;; consumer thread is supposed to take from the first channel which
;; happens to have a value available.  I. e. the following is not
;; going to work:
(comment
  (println "CH1:" (a/<!! ch-1))
  (println "CH2:" (a/<!! ch-2)))
;; because it will never reach the second expression unless something
;; is put to ch-1.
;; Try to solve it by using a third channel and the asynchronous put!
;; / take! operations.

(def chan-1 (chan))
(def chan-2 (chan))
(def chan-3 (chan))

(defn listen-both-and-print [c1 c2 c3]
  (go
    (loop []
      (do 
        (>! c3 (<! c1))
        (>! c3 (<! c2)))
      (when (some? (<! c3))
        (prn "value taken wherever is " (<! c3))
        (recur)))))

(listen-both-and-print chan-1 chan-2 chan-3)

(go (>! chan-1 "ketchup"))
(go (>! chan-2 "pickle"))

















(defn upper-caser-1
  [in]
  (let [out (chan)]
    (go (while true
          (>! out
              (clojure.string/upper-case (<! in)))))
    out))
(def in-1 (chan))
(def out-1 (upper-caser-1 in-1))
(>!! in-1 "leon")
(<!! out-1)

(defn upper-caser-2
  [in]
  (let [out (chan)]
    (go
      (>! out (clojure.string/upper-case (<! in))))
    out))
(def in-2 (chan))
(def out-2 (upper-caser-2 in-2))
(>!! in-2 "grapenthin")
(<!! out-2)
