;; https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

;; solution 1
(defn sum [list]
  (if (empty? list)
    0
    (+ (first list)
       (sum (rest list)))))
(defn max-profit [prices]
  (loop [length (count prices)
         cost (sum prices)
         profit 0
         index 0]
    (if (>= index length)
      profit
      (recur length
             (if (< (get prices index) cost)
               (get prices index)
               cost)
             (if (> (- (get prices index) cost) profit)
               (- (get prices index) cost)
               profit)
             (+ index 1)))))
(def trial1 (max-profit [7 6 4 3 1])) ;; 5
(def trial2 (max-profit [7 6 4 3 1])) ;; 0