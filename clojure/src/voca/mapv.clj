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

(defn mapv' [f col]
  (vec (map f col)))
(mapv' inc '(1 2 3))
;; => [2 3 4]
