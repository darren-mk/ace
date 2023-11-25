#lang racket

(define ft
  (future (lambda ()
            (displayln "future is triggered.")
            (+ 1 2))))

(touch ft)
;; future is triggered.
;; 3

(touch ft)
;; 3
