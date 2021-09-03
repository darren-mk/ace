;; https://4clojure.oxal.org/#/problem/20

;; Problem 20
;; Write a function which returns the second to last element from a sequence.
;; (= (__ (list 1 2 3 4 5)) 4)
;; (= (__ ["a" "b" "c"]) "b")
;; (= (__ [[1 2] [3 4]]) [1 2])

#lang racket/base

;; 1
(define (f1 l)
  (let ([index-second-to-last (- (length l) 2)])
    (list-ref l index-second-to-last)))
(equal? (f1 (list 1 2 3 4 5)) 4) ;; #t
(equal? (f1 '("a" "b" "c")) "b") ;; #t
(equal? (f1 '((1 2) (3 4))) '(1 2)) ;; #t
