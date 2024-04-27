#lang racket/base

(eqv? 1 1)
;; #t

(eqv? 1 1.0)
;; #f

(eqv? '(1 2 3) '(1 2 3))
;; #f
