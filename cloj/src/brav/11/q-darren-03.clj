;; there are three cars in racing,
;; and your program gets the name of the car
;; that comes in the goal first. 

(require '[clojure.core.async :refer
           [go go-loop timeout
            chan thread alts!!
            <! >! <!! >!!]])

;; 1
;; using thread and alts!!
(defn race1 [car-name track-channel]
  (thread (<!! (timeout (rand 5000)))
          (>!! track-channel car-name)))
(let [c1 (chan)
      c2 (chan)
      c3 (chan)]
  (do (race1 "ferrari" c1)
      (race1 "porsche" c2)
      (race1 "mustang" c3)
      (let [[name channel] (alts!! [c1 c2 c3])]
        (prn name " won!"))))

;; 2
;; using go and alts!!
(defn race2 [car-name track-channel]
  (go (<! (timeout (rand 5000)))
      (>! track-channel car-name)))
(let [c1 (chan)
      c2 (chan)
      c3 (chan)]
  (do (race2 "ferrari" c1)
      (race2 "porsche" c2)
      (race2 "mustang" c3)
      (let [[name channel] (alts!! [c1 c2 c3])]
        (prn name " won!"))))
