;; https://4clojure.oxal.org/#/problem/6

;; 1
(equal (list :a :b :c)
       (coerce (vector :a :b :c) 'list)) ;; T
