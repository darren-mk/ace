;; https://4clojure.oxal.org/#/problem/33

;; 1
(defn f1 [sq n]
  (apply concat
         (map (fn [x] (repeat n x))
              sq)))
(= (f1 [1 2 3] 2) '(1 1 2 2 3 3)) ;; => true 
(= (f1 [:a :b] 4) '(:a :a :a :a :b :b :b :b)) ;; => true 
(= (f1 [4 5 6] 1) '(4 5 6)) ;; => true 
(= (f1 [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])) ;; => true 
(= (f1 [44 33] 2) [44 44 33 33]) ;; => true 

;; 2
(defn f2 [coll n]
  (->> coll
       (map #(repeat n %))
       (apply concat)))
(= (f2 [1 2 3] 2)
   '(1 1 2 2 3 3)) ;; => true
(= (f2 [:a :b] 4)
   '(:a :a :a :a :b :b :b :b)) ;; => true
(= (f2 [4 5 6] 1)
   '(4 5 6)) ;; => true
(= (f2 [[1 2] [3 4]] 2)
   '([1 2] [1 2] [3 4] [3 4])) ;; => true
(= (f2 [44 33] 2)
   [44 44 33 33]) ;; => true

;; 3
(defn f3 [coll n]
  (->> coll
       (mapcat #(repeat n %))))
(= (f3 [1 2 3] 2)
   '(1 1 2 2 3 3)) ;; => true
(= (f3 [:a :b] 4)
   '(:a :a :a :a :b :b :b :b)) ;; => true
(= (f3 [4 5 6] 1)
   '(4 5 6)) ;; => true
(= (f3 [[1 2] [3 4]] 2)
   '([1 2] [1 2] [3 4] [3 4])) ;; => true
(= (f3 [44 33] 2)
   [44 44 33 33]) ;; => true

;; 4
(defn f4 [l n]
  (apply interleave (take n (repeat l))))
(= (f4 [1 2 3] 2) '(1 1 2 2 3 3)) ;; => true
(= (f4 [:a :b] 4) '(:a :a :a :a :b :b :b :b)) ;; => true
(= (f4 [4 5 6] 1) '(4 5 6)) ;; => true
(= (f4 [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])) ;; => true
(= (f4 [44 33] 2) [44 44 33 33]) ;; => true

;; 5
(defn f5 [l n]
  (reduce (fn [acc elem]
            (concat acc (take n (repeat elem))))
          []
          l))
(= (f5 [1 2 3] 2) '(1 1 2 2 3 3)) ;; => true
(= (f5 [:a :b] 4) '(:a :a :a :a :b :b :b :b)) ;; => true
(= (f5 [4 5 6] 1) '(4 5 6)) ;; => true
(= (f5 [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])) ;; => true
(= (f5 [44 33] 2) [44 44 33 33]) ;; => true
