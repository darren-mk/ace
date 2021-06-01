;; reduce
;; (reduce f coll) (reduce f val coll)
(reduce + []) ;; => 0           
(reduce + [1]) ;; => 1          
(reduce + [1 2]) ;; => 3        
(reduce + [1 2 3]) ;; => 6
(reduce + 1 []) ;; => 1        
(reduce + 1 [2 3]) ;; => 6
(reduce - [1 2 3]) ;; => -4
(reduce - 100 [1 2]) ;; => 97
(defn reduce-2 [f start coll]
  (loop [v start
         coll coll]
    (if (empty? coll)
      v
      (recur (f v (first coll)) (rest coll)))))
(reduce-2 + 1 [2 3]) ;; => 6
(reduce-2 * 10 [2 3]) ;; => 60
