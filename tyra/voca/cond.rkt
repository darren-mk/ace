#lang racket/base

(define (grade n)
  (cond [(< 8 n) "great"]
        [(< 5 n) "good"]
        [(< 3 n) "okay"]
        [else "try"]))
