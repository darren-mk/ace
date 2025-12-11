(take 2 [1 2 3 4 5]) ;; => (1 2)
(type (take 1 [1 2])) ;; => clojure.lang.LazySeq

(defn take-1
  ([n col]
   (take-1 [] n col))
  ([acc n [x & xs]]
   (lazy-seq
    (if (zero? n) acc
        (take-1 (conj acc x) (dec n) xs)))))
(take-1 2 [1 2 3 4 5]) ;; => (1 2)
(type (take-1 1 [1 2])) ;; => clojure.lang.LazySeq
