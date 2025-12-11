;; https://www.hackerrank.com/challenges/birthday-cake-candles

;; 1
(defn f1 [candles]
  (let [mx (apply max candles)
        cnt (count (filter #(= mx %) candles))]
    cnt))
(f1 [3 2 1 3])
