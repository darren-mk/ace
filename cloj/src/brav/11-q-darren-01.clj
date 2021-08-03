;; create an app that prints the following
;; at the same time from the beginning:
;; "a" at every 3 seconds
;; "b" at every 5 seconds
;; stop printing after given # of incidents. 

(require '[clojure.core.async :as a])

;; 1
;; using go an loop
(defn f1 [v t n]
  (a/go-loop [cnt 0]
    (when (<= cnt n) 
      (do (prn v)
          (a/<! (a/timeout t))
          (recur (inc cnt))))))
(do (f1 "a" 3000 5)
    (f1 "b" 5000 5))

;; 2
;; using channel, thread
(defn f2 [v t n]  
  (a/thread
    (loop [i 0]
      (when (< i n) 
        (Thread/sleep t)
        (prn v)
        (recur (inc i))))))
(do (f2 "a" 3000 5)
    (f2 "b" 5000 5))

;; 3
;; using channel, thread
(defn f3 [v t n]  
  (a/thread
    (loop [i 0]
      (when (< i n) 
        (a/<!! (timeout t))
        (prn v)
        (recur (inc i))))))
(do (f3 "a" 3000 5)
    (f3 "b" 5000 5))

;; 4
(defn f4 [v t n] 
  (a/go
    (loop [i 0]
      (when (< i n)
        (do (println v)
            (a/<! (a/timeout t))
            (recur (inc i)))))))
;; with go, these two statements
;; start exactly at the same time. 
(a/go (do (f4 "a" 3000 5)
          (f4 "b" 5000 5)))

(comment
  (Thread/sleep t)
  "blocks the current thread."
  "it is jvm construct."
  (a/timeout t)
  "creates a channel that closes after some time.")
