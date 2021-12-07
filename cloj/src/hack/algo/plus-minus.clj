;; https://www.hackerrank.com/challenges/plus-minus/problem?isFullScreen=true&h_r=next-challenge&h_v=zen

;; 1
(defn f1 [arr]
  (let [all (count arr)
        pos (->> arr (filter #(< 0 %)) count)
        neg (->> arr (filter #(< % 0)) count)
        zer (->> arr (filter zero?) count)
        pos-r (/ pos all 1.0)
        neg-r (/ neg all 1.0)
        zer-r (/ zer all 1.0)]
    (println pos-r)
    (println neg-r)
    (println zer-r)))
(f1 [-4 3 -9 0 4 1])
