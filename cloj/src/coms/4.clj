
(defn bubble-sort
  ([nums]
   (bubble-sort nums (count nums) 0 true))
  ([nums len cursor sorted]
   (cond
     (or (empty? nums) (= 1 len)) nums
     (<= (dec len) cursor) (if sorted nums (bubble-sort nums len 0 true))
     (< (get nums cursor) (get nums (inc cursor))) (bubble-sort nums len (inc cursor) sorted)
     :else (bubble-sort (-> nums
                            (assoc cursor (get nums (inc cursor)))
                            (assoc (inc cursor) (get nums cursor)))
                        len (inc cursor) false))))
(= [] (bubble-sort []))
(= [1] (bubble-sort [1]))
(= [1 2] (bubble-sort [1 2]))
(= [1 2] (bubble-sort [2 1]))
(= [1 2 3] (bubble-sort [1 2 3]))
(= [10 15 25 35 45 55 65] (bubble-sort [65, 55, 45, 35, 25, 15, 10]))
