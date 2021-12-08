;; https://www.hackerrank.com/challenges/staircase/problem?isFullScreen=true&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

;; 1
(defn f1 [n]
  (let [f (fn stair [x n]
            (if (<= n 0)
              ""
              (str (if (<= x 0) " " "#")
                   (stair (dec x) (dec n)))))]
    (doseq [i (range 1 (inc n))]
      (println (apply str (reverse (f i n)))))))
(f1 4)
