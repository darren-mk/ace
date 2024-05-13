(defmacro list-with-hundred (x y)
  `(list 100 ,x ,y))

(macroexpand '(list-with-hundred 3 7))
;; => (LIST 100 3 7), T
