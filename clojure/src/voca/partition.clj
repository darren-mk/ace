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

(partition 1 [:a :b :c])
;; => ((:a) (:b) (:c))

(defn partition'
  ([n col]
   (partition' n col []))
  ([n col acc]
   (if (empty? col) (seq acc)
       (partition'
        n (drop n col)
        (if (< (count col) n)
          acc
          (conj acc (take n col)))))))
(partition' 2 [1 2 3 4 5 6]) ;; => ((1 2) (3 4) (5 6))
(partition' 2 [1 2 3 4 5]) ;; => ((1 2) (3 4))
