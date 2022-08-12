#lang racket

(define v1
  (vector 1 2 3 4 5))

(vector-take v1 2)
;; '#(1 2)

v1
;; '#(1 2 3 4 5)
;; immutable
