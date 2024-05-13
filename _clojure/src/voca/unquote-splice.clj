`(+ ~(list 1 2 3))
;; => (clojure.core/+ (1 2 3))

`(+ ~@(list 1 2 3))
;; => (clojure.core/+ 1 2 3)
