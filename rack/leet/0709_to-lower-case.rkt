#lang racket/base

(require racket/contract)

(define/contract (to-lower-case s)
  (-> string? string?)
  (string-downcase s))
