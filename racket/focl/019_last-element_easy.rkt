#lang racket/base

(require racket/list)

;; https://4clojure.oxal.org/#/problem/19

;; 1
(define (f1 l)
  (first (reverse l)))
(equal? (f1 '(1 2 3 4 5)) 5) ;; #t
(equal? (f1 '(5 4 3)) 3) ;; #t
(equal? (f1 '("b" "c" "d")) "d") ;; #t

;; 2 
(define (f2 coll)
  (if (null? (cdr coll))
      (car coll)
      (f2 (cdr coll))))
(equal? (f2 '(1 2 3 4 5)) 5) ;; #t
(equal? (f2 '(1 2 3 4 5)) 5) ;; #t
(equal? (f2 '(5 4 3)) 3) ;; #t
(equal? (f2 '("b" "c" "d")) "d") ;; #t
