;; https://www.4clojure.com/problem/10

;; 1
(def v1 20)
(= v1 ((hash-map :a 10, :b 20, :c 30) :b)) ;; => true
(= v1 (:b {:a 10, :b 20, :c 30})) ;; => true
