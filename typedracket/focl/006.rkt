#lang typed/racket

#|
https://4clojure.oxal.org/#/problem/6
Problem 6, Vectors
Difficulty: elementary
Vectors can be constructed several ways. You can compare them with lists.
(= [__] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))
|#

(equal?
 (vector->list (vector 'a 'b 'c))
 (list 'a 'b 'c)) ;; #t
