#lang racket/base

(require racket/set)

(define st 
  (set 1))

(set? st)
;; #t

(set-mutable? st)
;; #f
