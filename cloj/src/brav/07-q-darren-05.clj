;; write a macro that takes and run
;; a list of three elements in infix order

(defmacro run-infix-of-3-elems
  [l]
  (list (second l)
        (first l)
        (last l)))
;; => #'user/run-infix-of-3-elems

(run-infix-of-3-elems (1 + 2))
;; => 3


;; Exercise: Multiple variables connect via infix like (1 + 2 + 3), no
;; minus etc

;; scheme: first = car , rest = cdr, cddr
