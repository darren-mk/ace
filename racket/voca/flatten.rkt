#lang racket

;; (flatten v) → list?
;; v : any/c
#| Flattens an arbitrary S-expression structure of pairs 
into a list. More precisely, v is treated as a binary tree 
where pairs are interior nodes, and the resulting list contains 
all of the non-null leaves of the tree in the same order as 
an inorder traversal. |#

(flatten '((a) b (c (d) . e) ()))
;; '(a b c d e)

(flatten 'a)
;; '(a)


;; implementation

(define (flatten-alt1 l)

  )
