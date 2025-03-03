;; frequencies
(frequencies [:a :a :b :b :b]) ;; => {:a 2, :b 3}
(distinct [:a :a :b :b :b]) ;; => (:a :b)
(group-by identity [1 1 2 2 2]) ;; => {1 [1 1], 2 [2 2 2]}
(count [1 2 3]) ;; => 3
(map count [[1 2 3] [4 5]]) ;; => (3 2) 

(defn frequencies' [coll]
  (let [gcoll (group-by identity coll)]
    (zipmap
     (keys gcoll)
     (map count (vals gcoll)))))

(frequencies' [1 1 2 2 2]) ;; => {1 2, 2 3}
(group-by identity [1 1 2 2 2]) ;; => {1 [1 1], 2 [2 2 2]}
(keys {1 [1 1], 2 [2 2 2]}) ;; => (1 2)
(vals {1 [1 1], 2 [2 2 2]}) ;; => ([1 1] [2 2 2])
(map count '([1 1] [2 2 2])) ;; => (2 3)
(zipmap '(1 2) '(2 3)) ;; => {1 2, 2 3}
(frequencies' [1 1 2 2 2])
(count (first '([1 1] [2 2 2])))

(defn frequencies'' [coll]
  (reduce (fn [m x] (assoc m x (inc (get m x))))
          (zipmap (distinct coll) (repeat 0))
          coll))
(frequencies'' [:a :a :b :b :b])
(frequencies'' [])

(defn frequencies''' [coll]
  (reduce
   (fn [m x] (assoc m x (inc (get m x 0))))
   {}
   coll))
(frequencies''' [:a :a :b :b :b])
(frequencies''' [])

(defn frequencies'''' [coll]
  (reduce
   (fn [m x] (update m x (fn [n] (if (nil? n) 1 (+ n 1)))))
   {}
   coll))
(frequencies'''' [:a :a :b :b :b])
(frequencies'''' [])

(defn frequencies''''' [coll]
  (reduce
   (fn [m x] (update m x #(inc (or % 0))))
   {}
   coll))
(frequencies''''' [:a :a :b :b :b]) ;; => {:a 2, :b 3}
(frequencies''''' []) ;; => {}
(or 5 0) ;; => 5
(or nil 3) ;; => 3

(defn frequencies'''''' [coll]
  (reduce
   (fn [m x] (update m x (fnil inc 0)))
   {}
   coll))
(frequencies'''''' [:a :a :b :b :b]) ;; => {:a 2, :b 3}
(frequencies'''''' []) ;; => {}
((fnil inc 0) nil) ;; => 1
((fnil inc 0) 3) ;; => 4
