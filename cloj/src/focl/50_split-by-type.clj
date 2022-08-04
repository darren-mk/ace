;; https://4clojure.oxal.org/#/problem/50

;; 1
(defn f1 [l]
  (set
   (vals
    (group-by type l))))
(= (set (f1 [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}) ;; => true
(= (set (f1 [:a "foo" "bar" :b])) #{[:a :b] ["foo" "bar"]}) ;; => true
(= (set (f1 [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]}) ;; => true
