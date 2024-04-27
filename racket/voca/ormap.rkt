#lang racket/base

(ormap even? '(1 2 3))
;; #t

(ormap even? '(1 3 5))
;; #f
