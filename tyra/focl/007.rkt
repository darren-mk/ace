#lang typed/racket

#|
https://4clojure.oxal.org/#/problem/7
Problem 7, conj on vectors
Difficulty: elementary
When operating on a Vector, the conj function will return a new vector with one or more items "added" to the end.
(= __ (conj [1 2 3] 4))
(= __ (conj [1 2] 3 4))
|#

(vector-append #(1 2 3) #(4)) ;; '#(1 2 3 4)
