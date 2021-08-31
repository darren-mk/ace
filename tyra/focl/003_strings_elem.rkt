;; https://4clojure.oxal.org/#/problem/3

;; Problem 3
;; Clojure strings are Java strings,
;; so you can use Java string methods on them.
;; (= __ (.toUpperCase "hello world"))

#lang typed/racket/base

;; 1
(equal? "HELLO WORLD"
        (string-upcase "hello world")) ;; #t
