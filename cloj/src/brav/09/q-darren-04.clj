;; describe differences between future and delay

;; neither future nor delay
(def abc
  (do (Thread/sleep 10000)
      (prn "aaaa")
      100))
;; blocked, no deref.
;; but still assigns the value.

;; future
(def def
  (future
    (Thread/sleep 10000)
    (prn "aaaa")
    100))
@def
;; instructions within future starts
;; when the definition is made.

;; delay
(def ghi
  (delay
    (Thread/sleep 10000)
    (prn "aaaa")
    100))
@ghi
(force ghi)
;; instructions within delay starts
;; when deref or force is triggered.
