(defmacro add-one (x)
  `(+ 1 ,x))

(add-one 3)
;; 4

(macroexpand '(add-one (+ 3 3)))
;; (+ 1 (+ 3 3))
;; T

(defmacro sum-list (l)
  `(+ ,@l))

(sum-list (1 2 3))
;; 6

(macroexpand '(sum-list (1 2 3)))
;; (+ 1 2 3)
;; T
