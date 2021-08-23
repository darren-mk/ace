;; exemplify differences between quote and syntax quote

'(+ 1 1 (inc 100))
;; => (+ 1 1 (inc 100))

`(+ 1 1 (inc 100))
;; => (clojure.core/+ 1 1 (clojure.core/inc 100))

`(+ 1 1 ~(inc 100))
;; => (clojure.core/+ 1 1 101)
