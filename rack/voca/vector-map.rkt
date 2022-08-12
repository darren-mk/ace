#lang racket

(vector-map add1 (vector 1 2 3))
;; '#(2 3 4)

(vector-map! add1 (vector 1 2 3))
;; '#(2 3 4)
