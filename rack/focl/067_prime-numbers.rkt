#lang racket

;; https://4clojure.oxal.org/#/problem/67

;; 1
#| define a helper function prime? that determines
a single number is prime or not. then define an iter
function that iterates for a sequence of prime numbers. |#
(define (f1 x)
  (define (prime? a)
    (zero?
     (length
      (filter (lambda (x)
                (zero?
                 (remainder a x)))
              (stream->list (in-range 2 (sub1 a)))))))
  (define (iter l n i)
    (if (equal? n (length l))
        l
        (iter
         (if (prime? i)
             (cons i l)
             l)
         n
         (add1 i))))
  (reverse (iter '() x 2)))
(equal? (f1 2) '(2 3)) ;; #t
(equal? (f1 5) '(2 3 5 7 11)) ;; #t
(equal? (last (f1 100)) 541) ;; #t
