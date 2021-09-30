#lang racket/base

(member "a" (list "a" "b" "c"))
;; '("a" "b" "c")

(member "d" (list "a" "b" "c"))
;; #f
