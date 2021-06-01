;; https://www.4clojure.com/problem/6


;; 1
(define v1 '(a b c))
(equal? v1 (vector->list (vector 'a 'b 'c))) ;; #t
