#lang racket/base

(define (pos? n)
  (if (< 0 n)
      #true
      #false))
