#lang racket

(vector-append (vector 1 2) (vector 3 4))
;; '#(1 2 3 4)

(define v1
  (vector 1 2 3))

(define v2
  (vector 4 5 6))

(vector-append v1 v2)
;; '#(1 2 3 4 5 6)

v1
;; '#(1 2 3)

v2
;; '#(4 5 6)
