;; https://www.geeksforgeeks.org/analysis-of-algorithms-set-2-asymptotic-analysis/

(defn linear-search [l x]
  (loop [i 0]
    (cond (<= (count l) i) -1
          (= x (get l i)) i
          :else (recur (inc i)))))

(linear-search [1 10 30 15] 30) ;; => 2

(defn get-sum [l]
  (if (zero? (mod (count l) 2))
    0
    (apply + l)))
(get-sum [1 2 3 4]) ;; => 0
(get-sum [1 2 3 4 5]) ;; => 15

(defn sum-a [l]
  (loop [l l
         acc 0]
    (if (empty? l)
      acc
      (recur (rest l) (+ acc (first l))))))
(sum-a [1 2 3 4 5]) ;; => 15
