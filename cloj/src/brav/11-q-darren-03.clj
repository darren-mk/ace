;; there are three cars in racing,
;; and your program gets the name of the car
;; that comes in the goal first. 

(require '[clojure.core.async :as a])

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

;; 3
;; using for and go 
(def cars ["feri" "posh" "tesl"])
(defn race3 [m]
  (let [c (a/chan)]
    (a/go
      (a/<! (a/timeout (rand 5000)))
      (a/>! c m))
    c))
(a/go 
  (let [cars-in-race (for [car cars]
                       (race3 car)) 
        [car channel] (a/alts! cars-in-race)]
    (println car " won!")))

;; 4
;; using for and go 
(def cars ["feri" "posh" "tesl"])
(defn f4 [m]
  (a/go
    (a/<! (a/timeout (rand 5000)))
    m))
(a/go 
  (let [cars-in-race (for [car cars]
                       (f4 car)) 
        [car channel] (a/alts! cars-in-race)]
    (println car " won!")))
