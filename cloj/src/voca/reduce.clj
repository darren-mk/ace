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

;; 
(defn print-unique
  "Interview question to ADT/Discovery by Dylan.
  Recommended to use `reduce` despite other possibilities."
  [input]
  (reduce 
   (fn [last-elem x] 
     (when (not= last-elem x)           
       (prn x)
       x
       ))
   nil 
   input))
;; => #'user/print-unique
(print-unique ["aaa" "aaa" "bbb"])
;; => "bbb"
