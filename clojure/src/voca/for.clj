(for [x [1 2 3]
      y [7 8 9]]
  (+ x y))
;; => (8 9 10 9 10 11 10 11 12)

(for [x [1 2 3]]
  (for [y [4 5 6]]
    (+ x y)))
;; => ((5 6 7) (6 7 8) (7 8 9))

(type (for [x [1 2 3]] x))
;; => clojure.lang.LazySeq
