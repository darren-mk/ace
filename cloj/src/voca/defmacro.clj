(defmacro infix [symbols]
  (list (second symbols)
        (first symbols)
        (last symbols)))

(infix (1 + 2))
;; => 3

(macroexpand '(infix (1 + 2)))
;; => (+ 1 2)

(defmacro when [test & body]
  (list 'if test (cons 'do body)))

(when (even? 2) (+ 1 2))
;; => 3

(macroexpand
 '(when (even? 2) (+ 1 2) (print "hi!")))
;; => (if (even? 2) (do (+ 1 2) (print "hi!")))
