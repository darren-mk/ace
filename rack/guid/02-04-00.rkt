#lang racket/base

;; 2.4 Pairs, Lists, and Racket Syntax

;; The cons function actually accepts any two values,
;; not just a list for the second argument. When the second argument is not empty and not itself produced by cons, the result prints in a special way. The two values joined with cons are printed between parentheses, but with a dot (i.e., a period surrounded by whitespace) in between:

    > (cons 1 2)

    '(1 . 2)
    > (cons "banana" "split")

    '("banana" . "split")

Thus, a value produced by cons is not always a list. In general, the result of cons is a pair. The more traditional name for the cons? function is pair?, and we’ll use the traditional name from now on.

The name rest also makes less sense for non-list pairs; the more traditional names for first and rest are car and cdr, respectively. (Granted, the traditional names are also nonsense. Just remember that “a” comes before “d,” and cdr is pronounced “could-er.”)

Examples:

    > (car (cons 1 2))

    1
    > (cdr (cons 1 2))

    2
    > (pair? empty)

    #f
    > (pair? (cons 1 2))

    #t
    > (pair? (list 1 2 3))

    #t

Racket’s pair datatype and its relation to lists is essentially a historical curiosity, along with the dot notation for printing and the funny names car and cdr. Pairs are deeply wired into the culture, specification, and implementation of Racket, however, so they survive in the language.

You are perhaps most likely to encounter a non-list pair when making a mistake, such as accidentally reversing the arguments to cons:

    > (cons (list 2 3) 1)

    '((2 3) . 1)
    > (cons 1 (list 2 3))

    '(1 2 3)

Non-list pairs are used intentionally, sometimes. For example, the make-hash function takes a list of pairs, where the car of each pair is a key and the cdr is an arbitrary value.

The only thing more confusing to new Racketeers than non-list pairs is the printing convention for pairs where the second element is a pair, but is not a list:

    > (cons 0 (cons 1 2))

    '(0 1 . 2)

In general, the rule for printing a pair is as follows: use the dot notation unless the dot is immediately followed by an open parenthesis. In that case, remove the dot, the open parenthesis, and the matching close parenthesis. Thus, '(0 . (1 . 2)) becomes '(0 1 . 2), and '(1 . (2 . (3 . ()))) becomes '(1 2 3).

