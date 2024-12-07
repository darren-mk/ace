;; https://4clojure.oxal.org/#/problem/43

;; 1
(defn f1 [l n]
  (->> (range n)
       (map #(drop % l))
       (map #(take-nth n %))))
(= (f1 [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
(= (f1 (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
(= (f1 (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))
