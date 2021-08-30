(partition 2 [1 2 3 4 5 6])
;; => ((1 2) (3 4) (5 6))

(partition 2 [1 2 3 4 5])
;; => ((1 2) (3 4))

(partition 3 '(1 2 3 4 5 6))
;; => ((1 2 3) (4 5 6))

(partition 2 #{1 2 3 4 5})
;; => ((1 4) (3 2))

(type (partition 2 [1 2 3 4]))
;; => clojure.lang.LazySeq
