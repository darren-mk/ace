(mapv inc [1 2 3])
;; => [2 3 4]

(map inc [1 2 3])
;; => (2 3 4)

(mapv + [1 2 3] [4 5 6])
;; => [5 7 9]

(map + [1 2 3] [4 5 6])
;; => (5 7 9)

(mapv + [1 2 3] (iterate inc 4))
;; => [5 7 9]

(map + [1 2 3] (iterate inc 4))
;; => (5 7 9)

;; The difference between map and mapv is that:
;; map return a lazy sequence,
;; mapv return a sequence.

(def result (map println [1 2 3]))
;; => #'focl.core/result

result
;;=> 1
;;   2
;;   3
;;   (nil nil nil)

(def result (mapv println [1 2 3]))
;;=> 1
;;   2
;;   3
;; => #'focl.core/result

result
;;=> [nil nil nil]

(type (map inc [1 2 3]))
;; => clojure.lang.LazySeq

(type (mapv inc [1 2 3]))
;; => clojure.lang.PersistentVector
