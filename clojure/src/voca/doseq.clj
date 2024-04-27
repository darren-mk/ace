;; doseq
;; mostly for side effects

;; with multiple sequences
(doseq [x [-1 0]
        y [1 2]] 
  (prn (* x y)))
;; -1 -2 0 0

;; with when conditional statement
(doseq [v [1 2 3 4]]
  (when (< v 3.3)
    (prn v " is good, smaller than 3.3")))
;; 1 " is good, smaller than 3.3"
;; 2 " is good, smaller than 3.3"
;; 3 " is good, smaller than 3.3"
