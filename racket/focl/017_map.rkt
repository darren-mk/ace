#lang racket/base

;; https://4clojure.oxal.org/#/problem/17

;; 1
(define v1 '(6 7 8))
(equal? v1 (map (lambda (x) (+ x 5)) '(1 2 3))) ;; #t
