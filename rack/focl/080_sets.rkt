#lang racket


(set 1 2 3 3)

(equal? (set 'a 'b 'c 'd) (set 'a 'a 'b 'c 'c 'c 'c 'd 'd))

(map (lambda (x) (print x) x) (set 1 2 3))

;;(= __ (clojure.set/union #{'a 'b 'c} #{'b 'c 'd}))

(map (lambda (x) (car x)) (hash "apple" 'red "banana" 'yellow))
