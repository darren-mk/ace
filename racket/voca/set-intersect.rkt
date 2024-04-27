#lang racket/base

(require racket/set)

(set-intersect (set 0 1 2 3) (set 2 3 4 5))
;; (set 2 3)
