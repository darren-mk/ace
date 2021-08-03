;; assume that you don't know how long the future item would take.
;; check at every second if the future is realized,
;; and once realized print the returned value.

(require '[clojure.core.async :refer
           [go go-loop timeout
            chan thread 
            <! >! <!! >!!]])

;; 1
;; using go, non-blocking
;; process green thread or co-routine
;; specifically compiled by core.async
;; executed by core.async not directly by jvm
;; there are 8 threads for go block statements
;; which is called "thread pool". 
(def fut1
  (future (Thread/sleep (rand 3000))
          "Patience is good!"))
(go-loop []
  (if (not (realized? fut1))
    (do (<! (timeout 1000))
        (recur))
    (prn @fut1)))

;; 2
;; using thread, blocking
;; by thread, you are creating your own thread.
(def fut1
  (future (Thread/sleep (rand 3000))
          "Patience is good!"))
(thread 
  (loop []
    (if (not (realized? fut))
      (do (Thread/sleep 1000)
          (recur))
      (prn @fut1))))
