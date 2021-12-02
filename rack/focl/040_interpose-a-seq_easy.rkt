#lang racket

;; https://4clojure.oxal.org/#/problem/40

;; 1
(define (f1 v l)
  (cdr
   (foldr (lambda (e r) (cons v (cons e r)))
          '()
          l)))
(equal? (f1 0 '(1 2 3)) '(1 0 2 0 3)) ;; #t
(equal? (apply string-append (f1 ", " '("one" "two" "three")))
        "one, two, three") ;; #t
(equal? (f1 'z '(a b c d)) '(a z b z c z d)) ;; #t
