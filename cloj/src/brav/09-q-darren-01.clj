;; create two alarms that will ring you
;; exactly after 3 and 5 seconds, respectively.

;; 1
;; sequentially, not asynchronously 
(do 
  (Thread/sleep 3000)
  (prn "ring after 3 seconds")
  (Thread/sleep 2000)
  (prn "ring after 5 seconds"))

;; 2
;; asynchronously using future
(do
  (future (Thread/sleep 3000)
          (prn "ring after 3 seconds"))
  (future (Thread/sleep 5000)
          (prn "ring after 5 seconds")))
