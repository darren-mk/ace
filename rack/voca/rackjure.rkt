#lang racket

(require rackjure)

(define a 1)

(define d {'a 1 'a 2})
;; '((a . 1) (a . 2))

(define e {'abc 123 'name "Darren"})
;; '((abc . 123) (name . "Darren"))
