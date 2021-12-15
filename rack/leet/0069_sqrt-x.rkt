#lang racket

;; https://leetcode.com/problems/sqrtx/

(define (half-accepting-round x)
  (if (= 0.5 (- x (round x)))
      (+ (round x) 1)
      (round x)))

(define (find-sqrt x guess)
  (let ([hlf (half-accepting-round (/ guess 2))])
    (if (<= (* hlf hlf) x)
        hlf
        (find-sqrt x hlf))))

(define/contract (my-sqrt x)
  (-> exact-integer? exact-integer?)
  (find-sqrt x x))
