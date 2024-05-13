;; https://www.4clojure.com/problem/6

;; 1
(= [:a :b :c]
   (list :a :b :c)
   (vec '(:a :b :c))
   (vector :a :b :c)) ;; => true

