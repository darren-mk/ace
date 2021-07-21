;; give me random numbers between 0 and 100
;; at every second for 10 times.

(require '[clojure.core.async :refer
           [go go-loop timeout
            chan thread 
            <! >! <!! >!!]])

;; 1
;; using go-loop, non-blocking
(go-loop [i 0]
  (when (< i 10)       
    (Thread/sleep 1000)
    (prn (+ i 1) (rand 100))
    (recur (inc i))))

;; 2
;; using thread, blocking
(thread
  (loop [i 0]
    (when (< i 10) 
      (Thread/sleep 1000)
      (prn (+ i 1) (rand 100))
      (recur (inc i)))))
