;; https://www.4clojure.com/problem/17

;; 1
(define v1 '(6 7 8))
(equal? v1 (map (lambda (x) (+ x 5)) '(1 2 3))) ;; #t
