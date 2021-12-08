;; https://www.hackerrank.com/challenges/compare-the-triplets/problem?isFullScreen=true

;; 1
(defn f1 [a b]
  (let [compare (map
                 (fn [x y]
                   (cond (< x y) [0 1]
                         (< y x) [1 0]
                         (= x y) [0 0]))
                 a b)
        summed (reduce
                (fn [[r1 r2] [x1 x2]]
                  [(+ r1 x1) (+ r2 x2)])
                compare)]
    summed))
(= [1 1] (f1 [1 2 3] [3 2 1])) ;; => true
