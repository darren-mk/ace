#lang racket

(take '(1 2 3 4 5) 3)
;; '(1 2 3)

;; 1
(define (r1-f orig-l new-l n)
  (if (zero? n)
      new-l
      (r1-f (cdr orig-l)
            (append new-l (list (car orig-l)))
            (- n 1))))
(define (take-r1 l n)
  (r1-f l '() n))
(take-r1 (list 1 2 3 4 5) 3)
;; '(1 2 3)
