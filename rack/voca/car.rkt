#lang racket/base

(car '(1 . 2))
;; 1

(car '(1 2 3))
;; 1

(map car 
     (list '(1 . 2)
           '(3 . 4)))
;; '(1 3)
