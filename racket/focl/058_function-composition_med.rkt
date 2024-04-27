;; https://4clojure.oxal.org/#/problem/58

#lang racket/base

(require racket/list)

;; 1
(define (f1 . fs)
  (lambda (. vs)
    (foldr (lambda (f result) (f result))
           (apply (last fs) vs)
           (rest fs))))
(equal? '(3 2 1) ((f1 rest reverse) '(1 2 3 4)))
(equal? 5 ((f1 (lambda (x) (+ x 3)) second) '(1 2 3 4)))

#|
(equal? true ((f1 zero? #(mod % 8) +) 3 5 7 9))
(equal? "HELLO" ((f1 #(.toUpperCase %)
                     #(apply str %)
                     take)
                 5
                 "hello world"))
