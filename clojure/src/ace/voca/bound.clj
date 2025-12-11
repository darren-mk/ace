(def foobar)
;; => #'user/foobar
(bound? #'foobar)
;; => false

(def boing 10)
;; => #'user/boing
(bound? #'boing)
;; => true

(defn plus3 [n] (+ 3 n))
;; => #'user/plus3
(bound? #'plus3)
;; => true

(def x nil)
;; => #'user/x
(bound? #'x)
;; => true

(bound? #'abc)
;; => Syntax error compiling var at (src/voca/bound.clj:21:1).
;;    Unable to resolve var: abc in this context
