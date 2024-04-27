#lang racket

(drop '(1 2 3 4 5) 2)
;; '(3 4 5)

(define a (list 1 2 3 4 5))
a
;; '(1 2 3 4 5)

(drop a 2)
;; '(3 4 5)

a
;; '(1 2 3 4 5)
