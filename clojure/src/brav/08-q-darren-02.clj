;; exmplify differences between unquote and unquote splicing

`(+ ~(list 1 2 3))
;; => (clojure.core/+ (1 2 3))

(eval `(+ ~(list 1 2 3)))
;; error

`(+ ~@(list 1 2 3))
;; => (clojure.core/+ 1 2 3)

(eval `(+ ~@(list 1 2 3)))
;; => 6
