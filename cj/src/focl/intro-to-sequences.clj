;; https://www.4clojure.com/problem/12

;; 1
(def v1 3)
(= v1 (first '(3 2 1))) ;; => true
(= v1 (second [2 3 4])) ;; => true
(= v1 (last (list 1 2 3))) ;; => true
