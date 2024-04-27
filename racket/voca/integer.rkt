#lang racket/base

(integer? 3)
;; #t

(integer? 3.0)
;; #t

(integer? 3.2)
;; #f
