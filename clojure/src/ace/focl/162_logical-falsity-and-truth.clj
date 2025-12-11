;; https://www.4clojure.com/problem/162

;; 1
(def v1 1)
(= v1 (if-not false 1 0)) ;; => true
(= v1 (if-not nil 1 0)) ;; => true
(= v1 (if true 1 0)) ;; => true
(= v1 (if [] 1 0)) ;; => true
(= v1 (if [0] 1 0)) ;; => true
(= v1 (if 0 1 0)) ;; => true
(= v1 (if 1 1 0)) ;; => true
