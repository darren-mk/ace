;; https://www.4clojure.com/problem/17

;; 1
(def v1 (list 6 7 8))
(= v1 (map #(+ % 5) '(1 2 3))) ;; => true
