#lang racket/base

(require racket/list)

;; 2.3.2 List Iteration from Scratch

;; Although map and other iteration functions are predefined,
;; they are not primitive in any interesting sense. You can
;; write equivalent iterations using a handful of list
;; primitives.

;; Since a Racket list is a linked list, the two core
;; operations on a non-empty list are

;; first: get the first thing in the list; and
;; rest: get the rest of the list.

;; Examples:

(first (list 1 2 3))
;; 1

(rest (list 1 2 3))
;; '(2 3)

;; To create a new node for a linked list—that is, to add
;; to the front of the list—use the cons function, which
;; is short for “construct.” To get an empty list to start
;; with, use the empty constant:

empty
;; '()

(cons "head" empty)
;; '("head")

(cons "dead" (cons "head" empty))
;; '("dead" "head")

;; To process a list, you need to be able to distinguish
;; empty lists from non-empty lists, because first and rest
;; work only on non-empty lists. The empty? function detects
;; empty lists, and cons? detects non-empty lists:

(empty? empty)
;; #t

(empty? (cons "head" empty))
;; #f

(cons? empty)
;; #f

(cons? (cons "head" empty))
;; #t

;; With these pieces, you can write your own versions of
;; the length function, map function, and more.

;; Examples:

(define (my-length lst)
  (cond
    [(empty? lst) 0]
    [else (+ 1 (my-length (rest lst)))]))

(my-length empty)
;; 0

(my-length (list "a" "b" "c"))
;; 3

(define (my-map f lst)
  (cond
    [(empty? lst) empty]
    [else (cons (f (first lst))
                (my-map f (rest lst)))]))

(my-map string-upcase (list "ready" "set" "go"))
;; '("READY" "SET" "GO")

;; If the derivation of the above definitions is
;; mysterious to you, consider reading How to Design
;; Programs. If you are merely suspicious of the use
;; of recursive calls instead of a looping construct,
;; then read on.
