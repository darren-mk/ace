#lang typed/racket

(define f (lambda ([x : Real]) (> x 5)))

(filter f '(3 4 5 6 7)) ;; '(6 7)
