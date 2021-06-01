;; https://www.4clojure.com/problem/30

;; 1
(defn f1 [vct]
  (loop [r []
         l vct]  
    (if (empty? l)
      r
      (recur
       (if (= (last r) (first l))
         r
         (conj r (first l)))
       (rest l)))))
(= (apply str (f1 "Leeeeeerrroyyy")) "Leroy") ;; => true
(= (f1 [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)) ;; => true
(= (f1 [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])) ;; => true

;; 2
(defn f2 [s]
  (->> s
       (partition-by identity)
       (map first)))
(= (apply str (f2 "Leeeeeerrroyyy")) "Leroy") ;; => true
(= (f2 [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)) ;; => true
(= (f2 [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])) ;; => true

;; 3
(defn f3 [coll]
  (reduce
   (fn [cl x] (if (= (last cl) x) cl (conj cl x)))
   []
   coll))
(= (apply str (f3 "Leeeeeerrroyyy")) "Leroy") ;; => true
(= (f3 [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)) ;; => true
(= (f3 [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])) ;; => true
