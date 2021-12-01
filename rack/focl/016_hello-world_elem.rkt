#lang racket/base

;; https://4clojure.oxal.org/#/problem/16

;; 1
(define (f1 s)
  (string-append "Hello, " s "!"))
(equal? (f1 "Dave") "Hello, Dave!") ;; #t
(equal? (f1 "Jenn") "Hello, Jenn!") ;; #t
(equal? (f1 "Rhea") "Hello, Rhea!") ;; #t
