
(distinct [1 2 2 3])
;; => (1 2 3)

(distinct (list 1 2 3 3))
;; => (1 2 3)

(defn distinct'
  ([col]
   (distinct' [] col))
  ([acc col]
   (if (empty? col) (seq acc)
       (if (contains? (set acc) (first col))
         (distinct' acc (rest col))
         (distinct' (conj acc (first col)) (rest col))))))
(distinct' [1 2 2 3]) ;; => (1 2 3)
