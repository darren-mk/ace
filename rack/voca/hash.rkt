#lang racket

(hash 1 2 3 4)
;; '#hash((1 . 2) (3 . 4))

(immutable? (hash 'a "b"))
;; #t

(hash? (hash 1 2))
;; #t

(let ((my-hash (hash 1 2 3 4)))
  (hash-ref my-hash 3))
;; 4
