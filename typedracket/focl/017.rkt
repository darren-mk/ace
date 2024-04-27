#lang typed/racket

#|
https://4clojure.oxal.org/#/problem/17
Problem 17, map
Difficulty: elementary
The map function takes two arguments:
a function (f) and a sequence (s).
Map returns a new sequence consisting of the result
of applying f to each item of s. Do not confuse the
map function with the map data structure.
(= __ (map #(+ % 5) '(1 2 3)))
|#

(map (lambda ([x : Number])
       (+ x 5)) '(1 2 3)) ;; '(6 7 8)
