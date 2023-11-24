#lang typed/racket

#|
https://4clojure.oxal.org/#/problem/10
Problem 10, Maps
Difficulty: elementary
Maps store key-value pairs. Both maps and keywords can be used as lookup functions. Commas are whitespace.
(= __ ((hash-map :a 10, :b 20, :c 30) :b))
(= __ (:b {:a 10, :b 20, :c 30}))
|#

(hash-ref (hash 'a 10 'b 20 'c 30) 'a) ;; 10
