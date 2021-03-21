;; doseq
;; mostly for side effects
(doseq [x [-1 0]
        y [1 2]] 
  (prn (* x y))) ;; -1 -2 0 0
