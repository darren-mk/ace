;; https://leetcode.com/problems/contains-duplicate/

;; solution 1
(defn contain-duplicate [nums]
  (not=
   (->> nums count)
   (->> nums set count)))
(def trial1 (contain-duplicate [1 2 3 4]))
(def trial2 (contain-duplicate [1 2 3 4]))