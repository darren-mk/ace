;; give me random numbers between 0 and 100
;; at every second for 10 times.

(require '[clojure.core.async :as a])

;; 1
;; using go-loop, non-blocking
(go-loop [i 0]
  (when (< i 10)       
    (<! (timeout 1000))
    (prn (+ i 1) (rand 100))
    (recur (inc i))))

;; 2
;; using thread, blocking
(thread
  (loop [i 0]
    (when (< i 10) 
      (<!! (timeout 1000))
      (prn (+ i 1) (rand 100))
      (recur (inc i)))))

;; 3
(a/go (loop [i 0]
        (when (< i 10) 
          (println (rand 100))
          (a/<! (a/timeout 1000))
          (recur (inc i)))))

;; 4
(a/go
  (doseq [i (range 10)]
    (do (println (rand 100))
        (a/<! (a/timeout 1000)))))
