#lang racket/base

(require racket/set)

(set? (set 1))
;; #t

(set-mutable? (set 1))
;; #f

(set 1 2 3 3 3 3 3)
;; (set 1 2 3)

(set 1 'a 2 'b 3 'c)
;; (set 'c 3 1 'b 2 'a)
