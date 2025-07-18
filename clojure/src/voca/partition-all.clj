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

(defn partition-all'
  ([n col]
   (partition-all' n col []))
  ([n [x & xs :as axs] acc]
   (cond (empty? axs) acc
         (zero? (count (last acc)))
         (partition-all'
          n xs
          (assoc acc 0 [x]))
         (< (count (last acc)) n)
         (partition-all'
          n xs
          (update acc (dec (count acc)) conj x))
         :else
         (partition-all'
          n xs
          (update acc (count acc) conj x)))))
(partition-all' 4 [1 2 3 4 5 6]) ;; => [[1 2 3 4] (6 5)]
(partition-all' 4 []) ;; => []
(partition-all' 4 [1]) ;; => [[1]]

(defn partition-all-2
  ([n col]
   (partition-all-2 [] n col))
  ([acc n col]
   (lazy-seq
    (if (empty? col) acc
        (partition-all-2
         (conj acc (take n col))
         n (drop n col))))))
(partition-all-2 4 [1 2 3 4 5 6]) ;; => ((1 2 3 4) (5 6))
(partition-all-2 4 []) ;; => ()
(partition-all-2 4 [1]) ;; => ((1))
