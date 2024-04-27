#lang racket/base

(member "a" (list "a" "b" "c"))
;; '("a" "b" "c")

(if (member "a" (list "a" "b" "c"))
    1 2)
;; 1

(member "d" (list "a" "b" "c"))
;; #f
