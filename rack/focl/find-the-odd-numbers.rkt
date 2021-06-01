;; https://www.4clojure.com/problem/25

;; 1
(define (f1 l)
  (filter (lambda (x) (odd? x)) l))
(equal? (f1 '(1 2 3 4 5)) '(1 3 5)) ;; #t
(equal? (f1 '(4 2 1 6)) '(1)) ;; #t
(equal? (f1 '(2 2 4 6)) '()) ;; #t
(equal? (f1 '(1 1 1 3)) '(1 1 1 3)) ;; #t
