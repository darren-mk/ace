#lang racket/base

(require racket/set)

(define mst
  (mutable-set 2))

(set? mst)
;; #f

(set-mutable? mst)
;; #t
