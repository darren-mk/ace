#lang racket

(define v1
  (vector 1 2 3 4 5))

(vector-take-right v1 2)
;; '#(4 5)

v1
;; '#(1 2 3 4 5)
