#lang racket

(define-syntax-rule (swap x y)
  (let ([tmp x])
    (set! x y)
    (set! y tmp)))

(define x 1)
(define y 2)
x ; 1
y ; 2

(swap x y)
x ; 2
y ; 1
