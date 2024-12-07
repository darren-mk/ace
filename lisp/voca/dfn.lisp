(defun add-1 (x)
  (+ x 1))

(add-1 2)
;; 3

(defmacro dfn (name args process)
  `(defun ,name ,args ,process))

(dfn add-1-r1 (x) (+ x 1))
;; add-1-r1

(add-1-r1 2)
;; 3

(macroexpand '(dfn add-1-r1 (x) (+ x 1)))
