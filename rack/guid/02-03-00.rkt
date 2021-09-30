#lang racket/base

;; 2.3 Lists, Iteration, and Recursion

;; Racket is a dialect of the language Lisp,
;; whose name originally stood for “LISt Processor.”
;; The built-in list datatype remains a prominent
;; feature of the language.

;; The list function takes any number of values and
;; returns a list containing the values:

(list "red" "green" "blue")
;; '("red" "green" "blue")

(list 1 2 3 4 5)
;; '(1 2 3 4 5)

;; A list usually prints with ', but the printed form
;; of a list depends on its content. See Pairs and
;; Lists for more information.

;; As you can see, a list result prints in the REPL
;; as a quote ' and then a pair of parentheses wrapped
;; around the printed form of the list elements.
;; There’s an opportunity for confusion here, because
;; parentheses are used for both expressions, such as
;; (list "red" "green" "blue"), and printed results,
;; such as '("red" "green" "blue"). In addition to the
;; quote, parentheses for results are printed in blue
;; in the documentation and in DrRacket, whereas
;; parentheses for expressions are brown.

;; Many predefined functions operate on lists.
;; Here are a few examples:

(length (list "hop" "skip" "jump")) ; count the elements
;; 3

(list-ref (list "hop" "skip" "jump") 0) ; extract by position
;; "hop"

(list-ref (list "hop" "skip" "jump") 1)
;; "skip"

(append (list "hop" "skip") (list "jump")) ; combine lists
;; '("hop" "skip" "jump")

(reverse (list "hop" "skip" "jump")) ; reverse order
;; '("jump" "skip" "hop")

(member "fall" (list "hop" "skip" "jump")) ; check for an element
;; #f
