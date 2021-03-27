;; https://www.4clojure.com/problem/18

;; 1
(def v1 '(6 7))
(= v1 (filter #(> % 5) '(3 4 5 6 7))) ;; => true
(= v1 (filter #(> % 5) '(3 4 5 6 7))) ;; => true
