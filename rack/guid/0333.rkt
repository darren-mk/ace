#lang racket/base



;;;; 3.7 Keywords

#| A keyword value is similar to a symbol (see Symbols), but its printed form is prefixed with #:. |#

#| +Reading Keywords in The Racket Reference documents the fine points of the syntax of keywords. |#

;; Examples:

(string->keyword "apple")
;; '#:apple

'#:apple
;; '#:apple

(eq? '#:apple (string->keyword "apple"))
;; #t

#| More precisely, a keyword is analogous to an identifier; in the same way that an identifier can be quoted to produce a symbol, a keyword can be quoted to produce a value. The same term “keyword” is used in both cases, but we sometimes use keyword value to refer more specifically to the result of a quote-keyword expression or of string->keyword. An unquoted keyword is not an expression, just as an unquoted identifier does not produce a symbol: |#

;; Examples:

;; not-a-symbol-expression
;; not-a-symbol-expression: undefined;
;; cannot reference an identifier before its definition
;; in module: top-level

;; #:not-a-keyword-expression
;; eval:2:0: #%datum: keyword misused as an expression
;; at: #:not-a-keyword-expression

#| Despite their similarities, keywords are used in a different way than identifiers or symbols. Keywords are intended for use (unquoted) as special markers in argument lists and in certain syntactic forms. For run-time flags and enumerations, use symbols instead of keywords. The example below illustrates the distinct roles of keywords and symbols. |#

;; Examples:

(define dir (find-system-path 'temp-dir)) ; not '#:temp-dir

(with-output-to-file (build-path dir "stuff.txt")
  (lambda () (printf "example\n"))
  ; optional #:mode argument can be 'text or 'binary
  #:mode 'text
  ; optional #:exists argument can be 'replace, 'truncate, ...
  #:exists 'replace)


;;;; 3.8 Pairs and Lists

#| A pair joins two arbitrary values. The cons procedure constructs pairs, and the car and cdr procedures extract the first and second elements of the pair, respectively. The pair? predicate recognizes pairs. |#

#| Some pairs print by wrapping parentheses around the printed forms of the two pair elements, putting a ' at the beginning and a . between the elements. |#

;; Examples:

(cons 1 2)
;; '(1 . 2)

(cons (cons 1 2) 3)
;; '((1 . 2) . 3)

(car (cons 1 2))
;; 1

(cdr (cons 1 2))
;; 2

(pair? (cons 1 2))
;; #t

#| A list is a combination of pairs that creates a linked list. More precisely, a list is either the empty list null, or it is a pair whose first element is a list element and whose second element is a list. The list? predicate recognizes lists. The null? predicate recognizes the empty list. |#

#| A list normally prints as a ' followed by a pair of parentheses wrapped around the list elements. |#

;; Examples:

null
;; '()

(cons 0 (cons 1 (cons 2 null)))
;; '(0 1 2)

(list? null)
;; #t

(list? (cons 1 (cons 2 null)))
;; #t

(list? (cons 1 2))
;; #f

#| A list or pair prints using list or cons when one of its elements cannot be written as a quoted value. For example, a value constructed with srcloc cannot be written using quote, and it prints using srcloc: |#

(srcloc "file.rkt" 1 0 1 (+ 4 4))
(srcloc "file.rkt" 1 0 1 8)
(list 'here (srcloc "file.rkt" 1 0 1 8) 'there)
(list 'here (srcloc "file.rkt" 1 0 1 8) 'there)
(cons 1 (srcloc "file.rkt" 1 0 1 8))
(cons 1 (srcloc "file.rkt" 1 0 1 8))
(cons 1 (cons 2 (srcloc "file.rkt" 1 0 1 8)))
(list* 1 2 (srcloc "file.rkt" 1 0 1 8))

;; See also list*.

#| As shown in the last example, list* is used to abbreviate a series of conses that cannot be abbreviated using list. |#

#| The write and display functions print a pair or list without a leading ', cons, list, or list*. There is no difference between write and display for a pair or list, except as they apply to elements of the list: |#

;; Examples:

(write (cons 1 2))
;; (1 . 2)

(display (cons 1 2))
;; (1 . 2)

(write null)
;; ()

(display null)
;; ()

(write (list 1 2 "3"))
;; (1 2 "3")

(display (list 1 2 "3"))
;; (1 2 3)

#| Among the most important predefined procedures on lists are those that iterate through the list’s elements: |#

(map (lambda (i) (/ 1 i))
     '(1 2 3))
;; '(1 1/2 1/3)

(andmap (lambda (i) (i . < . 3))
        '(1 2 3))
;; #f

(andmap (lambda [i] (< i 3))
        (list 1 2 3))
;; #f

(ormap (lambda (i) (i . < . 3))
             '(1 2 3))
;; #t

(filter (lambda (i) (i . < . 3))
        '(1 2 3))
;; '(1 2)

(foldl (lambda (v i) (+ v i))
             10
             '(1 2 3))
;; 16

(for-each (lambda (i) (display i))
                '(1 2 3))
;; 123

(member "Keys"
        '("Florida" "Keys" "U.S.A."))
;; '("Keys" "U.S.A.")

(assoc 'where
       '((when "3:30")
         (where "Florida")
         (who "Mickey")))
;; '(where "Florida")

#| +Pairs and Lists in The Racket Reference provides more on pairs and lists. |#

#| Pairs are immutable (contrary to Lisp tradition), and pair? and list? recognize immutable pairs and lists, only. The mcons procedure creates a mutable pair, which works with set-mcar! and set-mcdr!, as well as mcar and mcdr. A mutable pair prints using mcons, while write and display print mutable pairs with { and }: |#

;; Examples:

     (define p (mcons 1 2))
     p

    (mcons 1 2)
     (pair? p)

    #f
     (mpair? p)

    #t
     (set-mcar! p 0)
     p

    (mcons 0 2)
     (write p)

  ;;  {0 . 2}


#|            +Mutable Pairs and Lists in The Racket Reference provides more on mutable pairs. |#
