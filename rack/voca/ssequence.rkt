#lang racket/base

;; (sequence? v) → boolean?
;; v : any/c
;; Returns #t if v can be used as a sequence, #f otherwise.

(sequence? 42)
;; #t

(sequence? '(a b c))
;; #t

(sequence? "word")
;; #t

(sequence? #\x)
;; #f

(sequence? #(1 2 3))
;; #t

(sequence? (in-range 3 5))
;; #t
