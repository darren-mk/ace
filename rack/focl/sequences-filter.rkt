;; https://www.4clojure.com/problem/18

;; 1
(define v1 '(6 7))
(equal? v1 (filter (lambda (x) (> x 5)) '(3 4 5 6 7))) ;; #t
