(partition-by odd? [1 1 2 2 3 3])
;; => ((1 1) (2 2) (3 3))

(partition-by odd? [1 1 2 2 1 1])
;; => ((1 1) (2 2) (1 1))

(partition-by identity [1 1 2 3 4])
;; => ((1 1) (2) (3) (4))

(partition-by identity "Leerrroyy")
;; => ((\L) (\e \e) (\r \r \r) (\o) (\y \y))

(partition-by #(< % 3) [1 2 2 2 3 3 4 4 5 5 2])
;; => ((1 2 2 2) (3 3 4 4 5 5) (2))

(partition-by pos? [-3 -2 -3 0 1 2 3])
;; => ((-3 -2 -3 0) (1 2 3))

(defn partition-by-1
  ([pred col]
   (partition-by-1 [] pred col))
  ([acc pred [x & xs]]
   (lazy-seq
    (if-not x acc
            (let [pred' (fn [x] (and x (pred x)))
                  anchor (-> acc last last pred')
                  testable (pred' x)]
              (partition-by-1
               (if (= anchor testable)
                 (update acc (-> acc count dec) conj x)
                 (conj acc (vector x)))
               pred' xs))))))
(partition-by-1 odd? [1 1 2 2 3 3])
;; => ((1 1) (2 2) (3 3))
(partition-by-1 odd? [1 1 2 2 1 1])
;; => ((1 1) (2 2) (1 1))
(partition-by-1 identity [1 1 2 3 4])
;; => ((1 1) (2) (3) (4))
(partition-by-1 identity "Leerrroyy")
;; => ((\L) (\e \e) (\r \r \r) (\o) (\y \y))
(partition-by-1 #(< % 3) [1 2 2 2 3 3 4 4 5 5 2])
;; => ([1 2 2 2] [3 3 4 4 5 5] [2])
(partition-by-1 pos? [-3 -2 -3 0 1 2 3])
;; => ([-3 -2 -3 0] [1 2 3])


