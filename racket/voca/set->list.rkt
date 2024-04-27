#lang racket/base

(require racket/set)

(set->list (set 1 'a 2 'b 3 'c))
;; '(a 2 b 1 3 c)
