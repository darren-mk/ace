(defmacro comment (&rest code)
  nil)

(comment
 (print "hello")
 (+ 1 1)
 (defvar x 2))
