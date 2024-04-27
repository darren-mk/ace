#lang typed/racket

#|
https://4clojure.oxal.org/#/problem/8
Problem 8, Sets
Difficulty: elementary
Sets are collections of unique values.
(= __ (set '(:a :a :b :c :c :c :c :d :d)))
(= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))
|#

(set 'a 'a 'b 'c 'c 'c 'c 'd 'd)
;; (set 'c 'b 'a 'd)

(set-union (set 'a 'b 'c) (set 'b 'c 'd))
;; (set 'c 'b 'a 'd)
