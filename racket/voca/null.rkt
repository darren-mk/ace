#lang racket/base

(eq? null '())
;; #t

(list? null)
;; #t

(pair? null)
;; #f
