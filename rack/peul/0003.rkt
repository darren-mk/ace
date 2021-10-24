#|
https://projecteuler.net/problem=3
Largest prime factor
Problem 3
The prime factors of 13195 are 5, 7, 13 and 29.
What is the largest prime factor of the number 600851475143 ?
|#

#lang racket/base

(require racket/set)

(define (divisible? a b)
  (zero? (modulo a b)))
;; (divisible? 6 3) ;; #t
;; (divisible? 6 5) ;; #f

(define (prime? x)
  (define (iter x n)
    (cond [(<= x n) #t]
          [(divisible? x n) #f]
          [else (iter x (add1 n))]))
  (iter x 2))
;; (prime? 12) ;; #f
;; (prime? 13) ;; #t

(define (largest-prime-factor x)
  (define (iter x n largest)
    (cond [(<= x n) largest]
          [(and (prime? n)
                (divisible? x n))
           (iter x (add1 n) n)]
          [else (iter x (add1 n) largest)]))
  (iter x 2 1))
(largest-prime-factor 13195) ;; 29
;; (largest-prime-factor 600851475143) ;; NEED OPTIMIZE
