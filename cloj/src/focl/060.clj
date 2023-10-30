;; https://4clojure.oxal.org/#/problem/60


(defn f1
  ([f l]
   (f1 f l nil 0))
  ([f l init]
   (f1 f l init 0))
  ([f l init n]
   (lazy-seq (cons (apply f (if (zero? n) [init] (take n l)))
                     (f1 f l (inc n))))))
(take 5 (f1 + (range)))
(cons 1 2 [3 4])

(= (take 5 (f1 + (range))) [0 1 3 6 10])
(= (f1 conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
(= (last (f1 * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
