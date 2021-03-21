;; https://www.4clojure.com/problem/32

;; 1
(defn f1 [vct]
  (loop [l (into '() vct) r nil]
    (if (empty? l)
      r
      (recur
       (rest l)
       (conj r (first l) (first l))))))
(= (f1 [1 2 3]) '(1 1 2 2 3 3)) ;; => true
(= (f1 [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)) ;; => true
(= (f1 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])) ;; => true
(= (f1 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])) ;; => true

;; 2
(defn f2 [coll]
  (->> coll
       (mapcat #(take 2 (repeat %)))))
(= (f2 [1 2 3]) '(1 1 2 2 3 3)) ;; => true
(= (f2 [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)) ;; => true
(= (f2 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])) ;; => true
(= (f2 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])) ;; => true

;; 3
(defn f3 [coll]
  (reduce (fn [coll x] (conj coll x x)) [] coll))
(= (f3 [1 2 3]) '(1 1 2 2 3 3)) ;; => true
(= (f3 [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)) ;; => true
(= (f3 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])) ;; => true
(= (f3 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])) ;; => true
