;; https://www.4clojure.com/problem/157

;; 1
(zipmap [1 2 3] [4 5 6]) ;; => {1 4, 2 5, 3 6}
(range (count [:a :b :c])) ;; => (0 1 2)
(zipmap [:a :b :c] [0 1 2]) ;; => {:a 0, :b 1, :c 2}
(vec {:a 0, :b 1, :c 2}) ;; => [[:a 0] [:b 1] [:c 2]]
(defn f1 [coll]
  (->> coll
       (count)
       (range)
       (zipmap coll)
       (vec)))
(= (f1 [:a :b :c]) [[:a 0] [:b 1] [:c 2]]) ;; => true
(= (f1 [0 1 3]) '((0 0) (1 1) (3 2))) ;; => true
(= (f1 [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]]) ;; => true

;; 2
(defn f2 [coll]
  (partition
   2 
   (interleave coll (iterate inc 0))))
(= (f2 [:a :b :c]) [[:a 0] [:b 1] [:c 2]]) ;; => true
(= (f2 [0 1 3]) '((0 0) (1 1) (3 2))) ;; => true
(= (f2 [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]]) ;; => true 

;; f3
(defn f3 [coll]
  (as-> coll v
       (interleave v (iterate inc 0))
       (partition 2 v)))
(= (f3 [:a :b :c]) [[:a 0] [:b 1] [:c 2]]) ;; => true
(= (f3 [0 1 3]) '((0 0) (1 1) (3 2))) ;; => true
(= (f3 [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]]) ;; => true
