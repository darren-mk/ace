#lang typed/racket

#|
https://4clojure.oxal.org/#/problem/9
Problem 9, conj on sets
Difficulty: elementary
When operating on a set, the conj function returns a new set with one or more keys "added".
(= #{1 2 3 4} (conj #{1 4 3} __))
|#

(equal? (set 1 2 3 4)
        (set-union (set 1 4 3) (set 2))) ;; #t
