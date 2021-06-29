;; https://leetcode.com/problems/two-sum/

;; 1
(defn f1 [nums target]
  (let [pairs (into #{} (map #(- target %) nums))]
    (->> nums
         (zipmap (range))
         (filter (fn [x] (contains? pairs (val x))))
         (into {})
         (keys))))
(f1 [2 7 11 15] 9)
(f1 [3 2 4] 6)
(f1 [3 3] 6)
