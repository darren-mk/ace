(count nil) ;; => 0
(count []) ;; => 0
(count [1 2 3]) ;; => 3
(count {:one 1 :two 2}) ;; => 2
(count [1 \a "string" [1 2] {:foo :bar}]) ;; => 5
(count "string") ;; => 6

;; implementation using reduce
(defn count-using-reduce [coll]
  (reduce
   (fn [cnt v] (inc cnt))
   0
   coll))
(count-using-reduce [1 2 3]) ;; => 3
(count-using-reduce []) ;; => 0
(count-using-reduce nil) ;; => 0
(count-using-reduce "string") ;; => 6

;; implementation using loop/recur
(defn count-using-loop [coll]
  (loop [cnt 0
         coll coll]
    (if (empty? coll)
      cnt
      (recur (inc cnt)
             (rest coll)))))
(count-using-loop [1 2 3]) ;; => 3
(count-using-loop []) ;; => 0
(count-using-loop nil) ;; => 0
(count-using-loop "string") ;; => 6


