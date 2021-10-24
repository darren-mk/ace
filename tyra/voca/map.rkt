#lang typed/racket/base

(map
 (lambda ([x : Number]) (* x 10))
 (list 1 2 3))
;; '(10 20 30)
