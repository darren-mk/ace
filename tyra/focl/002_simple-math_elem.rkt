;; https://4clojure.oxal.org/#/problem/2

;; Problem 2
;; Innermost forms are evaluated first.
;; (= (- 10 (* 2 3)) __)

#lang typed/racket/base

;; 1
(equal? (- 10 (* 2 3)) 4) ;; #t
