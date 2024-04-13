;; https://4clojure.oxal.org/#/problem/60

(defn f1
  ([f seq]
   (f1 f seq '()))
  ([f seq result]
   (cond (empty? seq) result
         (empty? result) (f1 f (rest seq) (cons (f (first seq)) result))
         :else (f1 f (rest seq)
                   (cons
                    (f (first seq) (last result))
                    result)))))
(= (take 5 (f1 + (range))) [0 1 3 6 10])
(= (f1 conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
(= (last (f1 * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
