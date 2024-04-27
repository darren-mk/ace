#lang racket/base

(cons 1 '(2 3))
;; '(1 2 3)

(cons  '(2 3) 3)
;; '((2 3) . 3)

(cons 1 2)
;; '(1 . 2)
