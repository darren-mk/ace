;; you need a 5-digit random number within 2 seconds.
;; past that, the number is useless. 
;; implement this with core.async. 

(require '[clojure.core.async :as a])

;; 1
;; using alt!
(def calc-ch (a/chan))
(a/go
  (a/alt!
    (a/timeout 1000) :timed-out
    [[calc-ch (do
                (a/<! (a/timeout (rand 3000))) ;; not conventional
                "got it!")]] :calculated)
  (prn (a/<! calc-ch)))

;; 2
;; using alts!
;; not sure, help me leon.
;; leon : try with alts! first. 

