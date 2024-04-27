(partition-all 4 [1 2 3 4 5 6])
;; => ((1 2 3 4) (5 6))

(partition-all 3 [0 1 :a "x" 3 [7 8] '(:g 7)])
;; => ((0 1 :a) ("x" 3 [7 8]) ((:g 7)))

(partition-all 2 4 [0 1 2 3 4 5 6 7 8 9])
;; => ((0 1) (4 5) (8 9))

;; difference from partition
(partition 4 [1 2 3 4 5 6])
;; => ((1 2 3 4))

(partition-all 2 [1 2 3 4 5])
;; => ((1 2) (3 4) (5))

(type (partition-all 2 [1 2 3 4 5]))
;; => clojure.lang.LazySeq
