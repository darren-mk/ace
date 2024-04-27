;; https://4clojure.oxal.org/#/problem/30

;; Problem 30
;; Write a function which removes consecutive duplicates from a sequence.
;; (= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
;; (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
;; (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

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

((partition-by even?) [ 1 3 2 3 3 3 4 4 5])


;; 3
(defn f3 [coll]
  (reduce
   (fn [cl x] (if (= (last cl) x) cl (conj cl x)))
   []
   coll))
(= (apply str (f3 "Leeeeeerrroyyy")) "Leroy") ;; => true
(= (f3 [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)) ;; => true
(= (f3 [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])) ;; => true

;; 4
(defn f4 [coll]
  (reduce
   (fn [x elem]
     (if (= (last x) elem)
       x
       (conj x elem)))
   []
   coll));; => #'user/f4
(= (apply str (f4 "Leeeeeerrroyyy")) "Leroy") ;; => true
(= (f4 [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)) ;; => true
(= (f4 [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])) ;; => true

;; e
(defn f-e [coll]
  (loop [collected []
         coll coll]
    (if (empty? coll)
      collected
      (if (= (first coll) (last collected))
        (recur collected (rest coll))
        (recur (conj collected (first coll)) (rest coll))))))
(= (apply str (f-e "Leeeeeerrroyyy")) "Leroy") ;; => true
(= (f-e [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)) ;; => true
(= (f-e [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])) ;; => true

;; f
(defn f-f [coll]
  (reduce (fn [acc x] (if (= (last acc) x)
                        acc
                        (conj acc x)))
          []
          coll))
(= (apply str (f-f "Leeeeeerrroyyy")) "Leroy") ;; => true
(= (f-f [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)) ;; => true
(= (f-f [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])) ;; => true
