;; there are three cars in racing,
;; and your program gets the name of the car
;; that comes in the goal first. 

(require '[clojure.core.async :refer
           [go go-loop timeout
            chan thread alts!!
            <! >! <!! >!!]])

;; 1
;; using alts!!
(defn race [car-name track-channel]
  (thread (<!! (timeout (rand 5000)))
          (>!! track-channel car-name)))
(let [c1 (chan)
      c2 (chan)
      c3 (chan)]
  (do (race "ferrari" c1)
      (race "porsche" c2)
      (race "mustang" c3)
      (let [[name channel] (alts!! [c1 c2 c3])]
        (prn name " won!"))))
