;; https://www.4clojure.com/problem/49

;; 1
(defn f1 [n coll]
  [(take n coll)
   (drop n coll)])
(= (f1 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]]) ;; => true
(= (f1 1 [:a :b :c :d]) [[:a] [:b :c :d]]) ;; => true
(= (f1 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]]) ;; => true
