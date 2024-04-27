#lang racket/base

(define ht (make-hash))

ht
;; '#hash()

(hash-set! ht 1 2)

ht
;; '#hash((1 . 2))

(hash-set! ht 'a "bc")

ht
;; '#hash((1 . 2) (a . "bc"))

(hash-ref ht 'a)
;; "bc"

(hash-ref ht 'c "not here")
;; "not here"

(hash-ref ht 'c null)
;; '()
