;; https://www.4clojure.com/problem/7

;; 1
(def v1 [1 2 3 4])
(= v1 (conj [1 2 3] 4)) ;; => true
(= v1 (conj [1 2] 3 4)) ;; => true


