#lang typed/racket

(define f (lambda ([x : Number]) (* x 10)))

(f 3) ;; 30
