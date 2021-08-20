;; https://www.geeksforgeeks.org/bubble-sort/

;; 1
(defn bubble [ys x]
  (if-let [y (peek ys)]
    (if (< x y)
      (conj (pop ys) x y)
      (conj ys x))
    [x]))
(defn bubble-sort [xs]
  (let [ys (reduce bubble [] xs)]
    (if (= xs ys)
      xs
      (recur ys))))
(bubble-sort [3 5 4 2 6 1])
;; => [1 2 3 4 5 6]
(sort [3 5 4 2 6 1])
;; => (1 2 3 4 5 6)
