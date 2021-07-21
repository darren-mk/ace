;; create an app that prints the following
;; at the same time from the beginning:
;; "a" at every 3 seconds
;; "b" at every 5 seconds
;; stop printing after given # of incidents. 

(require '[clojure.core.async :refer
           [go go-loop timeout
            chan thread 
            <! >! <!! >!!]])

;; 1
;; using go an loop
(defn f1 [v t n]
  (go-loop [cnt 0]
    (when (<= cnt n) 
      (do (prn v)
          (<! (timeout t))
          (recur (inc cnt))))))
(do (f1 "a" 3000 5)
    (f1 "b" 5000 5))

;; 2
;; using channel, thread
(defn f2 [v t n]  
  (thread
    (loop [i 0]
      (when (< i n) 
        (Thread/sleep t)
        (prn v)
        (recur (inc i))))))
(do (f2 "a" 3000 5)
    (f2 "b" 5000 5))

;; 2
;; using channel, thread
(defn f2 [v t n]  
  (thread
    (loop [i 0]
      (when (< i n) 
        (<!! (timeout t))
        (prn v)
        (recur (inc i))))))
(do (f2 "a" 3000 5)
    (f2 "b" 5000 5))

(comment
  "it seems that "
  (Thread/sleep t) " and "
  (timeout t)
  "doens't make difference "
  "at least with above examples.")
