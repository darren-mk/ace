#lang racket/base

;; 2.3.1 Predefined List Loops

;; In addition to simple operations like append,
;; Racket includes functions that iterate over the
;; elements of a list. These iteration functions play
;; a role similar to for in Java, Racket, and other
;; languages. The body of a Racket iteration is packaged
;; into a function to be applied to each element, so
;; the lambda form becomes particularly handy in
;; combination with iteration functions.

;; Different list-iteration functions combine iteration
;; results in different ways. The map function uses the
;; per-element results to create a new list:

(map sqrt (list 1 4 9 16))
;; '(1 2 3 4)

(map (lambda (i)
       (string-append i "!"))
     (list "peanuts" "popcorn" "crackerjack"))
;; '("peanuts!" "popcorn!" "crackerjack!")

;; The andmap and ormap functions combine the results
;; by anding or oring:

(andmap string? (list "a" "b" "c"))
;; #t

(andmap string? (list "a" "b" 6))
;; #f

(ormap number? (list "a" "b" 6))
;; #t

The map, andmap, and ormap functions can all handle multiple lists, instead of just a single list. The lists must all have the same length, and the given function must accept one argument for each list:

    > (map (lambda (s n) (substring s 0 n))
           (list "peanuts" "popcorn" "crackerjack")
           (list 6 3 7))

    '("peanut" "pop" "cracker")

The filter function keeps elements for which the body result is true, and discards elements for which it is #f:

    > (filter string? (list "a" "b" 6))

    '("a" "b")
    > (filter positive? (list 1 -2 6 7 0))

    '(1 6 7)

The foldl function generalizes some iteration functions. It uses the per-element function to both process an element and combine it with the “current” value, so the per-element function takes an extra first argument. Also, a starting “current” value must be provided before the lists:

    > (foldl (lambda (elem v)
               (+ v (* elem elem)))
             0
             '(1 2 3))

    14

Despite its generality, foldl is not as popular as the other functions. One reason is that map, ormap, andmap, and filter cover the most common kinds of list loops.

Racket provides a general list comprehension form for/list, which builds a list by iterating through sequences. List comprehensions and related iteration forms are described in Iterations and Comprehensions.
