;; https://4clojure.oxal.org/#/problem/19

;; Problem 19
;; Write a function which returns the last element in a sequence.
;; (= (__ [1 2 3 4 5]) 5)
;; (= (__ '(5 4 3)) 3)
;; (= (__ ["b" "c" "d"]) "d")
;; Special Restrictions : last

#lang racket/base

(require racket/list)

;; 1
(define (f1 l)
  (first (reverse l)))
(equal? (f1 '(1 2 3 4 5)) 5) ;; #t
(equal? (f1 '(5 4 3)) 3) ;; #t
(equal? (f1 '("b" "c" "d")) "d") ;; #t
