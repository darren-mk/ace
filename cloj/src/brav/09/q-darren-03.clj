;; assume that you don't know how long the future item would take.
;; check at every second if the future is realized,
;; and once realized print the returned value.

(require '[clojure.core.async :refer
           [go go-loop timeout
            chan thread 
            <! >! <!! >!!]])

;; 1
;; using go, non-blocking
(def fut1
  (future (Thread/sleep (rand 3000))
          "Patience is good!"))
(go-loop []
  (if (not (realized? fut))
    (do (Thread/sleep 1000)
        (recur))
    (prn @fut1)))

;; 2
;; using thread, blocking
(def fut1
  (future (Thread/sleep (rand 3000))
          "Patience is good!"))
(thread 
  (loop []
    (if (not (realized? fut))
      (do (Thread/sleep 1000)
          (recur))
      (prn @fut1))))
