(defn pos-nums [n]
  (lazy-seq (cons n (pos-nums (inc n)))))
(take 5 (pos-nums 2)) ;; => (2 3 4 5 6)

(defn abc [n]
  (lazy-seq (cons n (abc (inc n)))))
(take 5 (abc 11)) ;; => (11 12 13 14 15)

(defn repeat-2 [n]
  (lazy-seq (cons n (repeat-2 n))))
(take 3 (repeat-2 1))
