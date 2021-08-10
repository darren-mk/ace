;; define 5 variables
;; containing random numbers

;; 1
(for [var-name ['a 'b 'c 'd 'e]]
  (eval (list 'def
              var-name
              (rand 100))))
a
;; => 98.44627362115475
b
;; => 74.83453802204795
c
;; => 46.145183312814055
d
;; => 47.30426309209601
e
;; => 72.4049295314904


;; Follow up exercise: Implement this as a macro, don't use eval.
