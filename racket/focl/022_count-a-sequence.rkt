#lang racket/base

;; https://4clojure.oxal.org/#/problem/22

;; 1
(define (f1 l)
  (if (null? l)
      0
      (+ 1 (f1 (cdr l)))))
(equal? (f1 '(1 2 3 3 1)) 5) ;; #t
(equal? (f1 (string->list "Hello World")) 11) ;; #t
(equal? (f1 '((1 2) (3 4) (5 6))) 3) ;; #t
(equal? (f1 '(13)) 1) ;; #t
(equal? (f1 '(#:a #:b #:c)) 3) ;; #t

;; 2
(define (f2 l)
  (foldl (lambda (_ b) (+ b 1))
         0
         l))
(equal? (f2 '(1 2 3 3 1)) 5) ;; #t
(equal? (f2 (string->list "Hello World")) 11) ;; #t
(equal? (f2 '((1 2) (3 4) (5 6))) 3) ;; #t
(equal? (f2 '(13)) 1) ;; #t
(equal? (f2 '(#:a #:b #:c)) 3) ;; #t

;; 3
(define (f3 l)
  (foldr (lambda (_ b) (+ b 1))
         0
         l))
(equal? (f3 '(1 2 3 3 1)) 5) ;; #t
(equal? (f3 (string->list "Hello World")) 11) ;; #t
(equal? (f3 '((1 2) (3 4) (5 6))) 3) ;; #t
(equal? (f3 '(13)) 1) ;; #t
(equal? (f3 '(#:a #:b #:c)) 3) ;; #t

;; 4
(define (f4 l)
  (length l))
(equal? (f4 '(1 2 3 3 1)) 5) ;; #t
(equal? (f4 (string->list "Hello World")) 11) ;; #t
(equal? (f4 '((1 2) (3 4) (5 6))) 3) ;; #t
(equal? (f4 '(13)) 1) ;; #t
(equal? (f4 '(#:a #:b #:c)) 3) ;; #t
