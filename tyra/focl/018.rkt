#lang typed/racket

#|
https://4clojure.oxal.org/#/problem/18
Problem 18, filter
Difficulty: elementary
The filter function takes two arguments:
a predicate function (f) and a sequence (s).
Filter returns a new sequence consisting of
all the items of s for which (f item) returns true.
(= __ (filter #(> % 5) '(3 4 5 6 7)))
|#

(filter (lambda ([x : Real]) (> x 5)) '(3 4 5 6 7)) ;; '(6 7)
