#lang racket

;; https://4clojure.oxal.org/#/problem/6

;; 1
(equal? '(a b c) (vector->list (vector 'a 'b 'c))) ;; #t
