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

(defn count-d [[x & xs]]
  (if-not x 0 (+ 1 (count-d xs))))
(count-d [1 2 3]) ;; => 3
(count-d []) ;; => 0
(count-d nil) ;; => 0
(count-d "string") ;; => 6

(defn count-e
  ([coll]
   (count-e 0 coll))
  ([acc [x & xs]]
   (if-not x acc
           (count-e (inc acc) xs))))
(count-e [1 2 3]) ;; => 3
(count-e []) ;; => 0
(count-e nil) ;; => 0
(count-e "string") ;; => 6
