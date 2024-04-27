#lang racket/base

(vector-ref (vector 1 2 3) 0)
;; 1

(vector-ref #(1 2 3 4) 0)
;; 1

(vector-ref #(1 2 3 4) 2)
;; 3

(vector-ref #("a" "b" "c") 2)
;; "c"
