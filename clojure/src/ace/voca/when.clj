(ns voca.when)

(when true 1) :=> 1
(when false 1) :=> nil
(when (< 1 2) 1) :=> 1

(defmacro when-a [b & body]
  `(if ~b ~@body nil))

(macroexpand '(when-a true 1)) :=> (if true 1 nil)
(when-a true 1) :=> 1
(when-a false 1) :=> nil
(when-a (< 1 2) 1) :=> 1

(defmacro when-b [b & body]
  (list 'if b (cons 'do body) nil))

(macroexpand '(when-b true 1))
;; => (if true (do 1) nil)
(when-b true 1) :=> 1
(when-b false 1) :=> nil
(when-b (< 1 2) 1) :=> 1
(when-b true (do (print "ye") 1))
