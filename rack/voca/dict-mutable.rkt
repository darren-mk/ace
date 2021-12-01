#lang racket/base

(require racket/dict)

(dict-mutable? #hash((a . "apple")))
;; #f

(dict-mutable? (make-hash))
;; #t

(dict-mutable? '#("apple" "banana"))
;; #f

(dict-mutable? (vector "apple" "banana"))
;; #t

(dict-mutable? '((a . "apple") (b . "banana")))
;; #f
