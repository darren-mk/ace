#lang racket/base

(list-ref '(1 2 3 4) 0)
;; 1

(list-ref '(1 2 3 4) 2)
;; 3

(let* ([l '(1 2 3 4)]
      [n (length l)]) 
  (list-ref l (- n 1)))
;; 4

(list-ref '("a" "b" "c") 2)
;; "c"
