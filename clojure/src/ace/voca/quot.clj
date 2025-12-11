;; quot[ient] of dividing numerator by denominator
(quot 5 2) ;; => 2
(quot 10 3) ;; => 3

(defn quot' 
  ([n d]
   (quot' n d 0))
  ([n d q]
   (if (< n d) q (recur (- n d) d (inc q)))))
(quot' 5 2) ;; => 2
(quot' 10 3) ;; => 3

(defn quot''
  ([n d]
   (quot'' n d 0))
  ([n d q]
   (if (< n d) q (quot'' (- n d) d (inc q)))))
(quot'' 5 2) ;; => 2
(quot'' 10 3) ;; => 3
(quot' 1000000 3)  ;; Works fine (tail recursion)
#_(quot'' 1000000 3) ;; StackOverflowError (deep recursion)
