;; https://4clojure.oxal.org/#/problem/5

;; Problem 5
;; When operating on a list,
;; the conj function will return a new list
;; with one or more items "added" to the front.
;; (= __ (conj '(2 3 4) 1))
;; (= __ (conj '(3 4) 2 1))

#lang typed/racket/base

;; 1
(equal? '(1 2 3 4) (cons 1 '(2 3 4))) ;; #t
(equal? '(1 2 3 4) (cons 1 (cons 2 '(3 4)))) ;; #t
