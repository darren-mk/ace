#lang racket/base

(andmap even? '(2 4 6))
;; #t

(andmap even? '(1 2 3))
;; #f
