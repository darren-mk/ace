;; https://www.4clojure.com/problem/22

;; 1
(defn f1 [coll]
  (loop [i 0
         coll coll]
    (if (empty? coll)
      i
      (recur (inc i)
             (rest coll)))))
(= (f1 '(1 2 3 3 1)) 5) ;; => true
(= (f1 "Hello World") 11) ;; => true
(= (f1 [[1 2] [3 4] [5 6]]) 3) ;; => true
(= (f1 '(13)) 1) ;; => true
(= (f1 '(:a :b :c)) 3) ;; => true

;; 2
(defn f2 [coll]
  (apply max 
         (keys 
          (zipmap (iterate inc 1) coll))))
(= (f2 '(1 2 3 3 1)) 5) ;; => true
(= (f2 "Hello World") 11) ;; => true
(= (f2 [[1 2] [3 4] [5 6]]) 3) ;; => true
(= (f2 '(13)) 1) ;; => true
(= (f2 '(:a :b :c)) 3) ;; => true
