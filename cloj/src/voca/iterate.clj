(take 10 (iterate (fn [x] (+ x 2)) 10))
;; => (10 12 14 16 18 20 22 24 26 28)

(defn iterate-a [f x]
  (lazy-seq (cons x (iterate-a f (f x)))))

(take 10 (iterate-a (fn [x] (+ x 2)) 10))
;; => (10 12 14 16 18 20 22 24 26 28)
