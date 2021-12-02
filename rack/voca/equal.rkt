#lang racket/base

(equal? 1 1)
;; #t

(equal? '(1 2 3) '(1 2 3))
;; #t

(equal? 1 1.0)
;; #f
