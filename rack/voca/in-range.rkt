#lang racket/base

(in-range 5)
;; #<stream>

(for/list ([i (in-range 5)])
  i) ;; '(0 1 2 3 4)

(for/list ([i (in-range 3 5)])
  i) ;; '(3 4)

