(count nil) ;; => 0
(count []) ;; => 0
(count [1 2 3]) ;; => 3
(count {:one 1 :two 2}) ;; => 2
(count [1 \a "string" [1 2] {:foo :bar}]) ;; => 5
(count "string") ;; => 6

;; implementation
;; a
(defn count-a [coll]
  (reduce (fn [measure item] (inc measure))
          0
          coll))
(count-a nil) ;; => 0
(count-a []) ;; => 0
(count-a [1 2 3]) ;; => 3
(count-a {:one 1 :two 2}) ;; => 2
(count-a [1 \a "string" [1 2] {:foo :bar}]) ;; => 5
(count-a "string") ;; => 6
;; b
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

(defn count'''
  ([items]
   (count''' 0 items))
  ([acc [x & xs]]
   (if xs
     (count''' (inc acc) xs)
     (if x (inc acc) acc))))
(count''' [1 2 3]) ;; => 3
(count''' []) ;; => 0
(count''' nil) ;; => 0
(count''' "string") ;; => 6
