#lang racket/base

;; 3.6 Symbols

#| A symbol is an atomic value that prints like an 
identifier preceded with '. An expression that starts 
with ' and continues with an identifier produces 
a symbol value. |#

;; Examples:

'a
;; 'a

(symbol? 'a)
;; #t

#| For any sequence of characters, exactly one corresponding 
symbol is interned; calling the string->symbol procedure, or 
reading a syntactic identifier, produces an interned symbol. 
Since interned symbols can be cheaply compared with eq? (and 
thus eqv? or equal?), they serve as a convenient values to use 
for tags and enumerations. |#

#| Symbols are case-sensitive. By using a #ci prefix or in other 
ways, the reader can be made to case-fold character sequences to 
arrive at a symbol, but the reader preserves case by default. |#

;; Examples:

(eq? 'a 'a)
;; #t

(eq? 'a (string->symbol "a"))
;; #t

(eq? 'a 'b)
;; #f

(eq? 'a 'A)
;; #f

#ci'A
;; 'a

#| Any string (i.e., any character sequence) can be supplied 
to string->symbol to obtain the corresponding symbol. For reader 
input, any character can appear directly in an identifier, except 
for whitespace and the following special characters: 
( ) [ ] { } " , ' ` ; # | \ |#

#| Actually, # is disallowed only at the beginning of a symbol, 
and then only if not followed by %; otherwise, # is allowed, too. 
Also, . by itself is not a symbol. |#

#| Whitespace or special characters can be included in an identifier 
by quoting them with | or \. These quoting mechanisms are used in 
the printed form of identifiers that contain special characters or 
that might otherwise look like numbers. |#

;; Examples:

(string->symbol "one, two")
;; '|one, two|

(string->symbol "6")
;; '|6|

#| +Reading Symbols in The Racket Reference documents the fine points 
of the syntax of symbols. |#

#| The write function prints a symbol without a ' prefix. The display 
form of a symbol is the same as the corresponding string. |#

;; Examples:

(write 'Apple)
;; Apple

(display 'Apple)
;; Apple

(write '|6|)
;; |6|

(display '|6|)
;; 6

#| The gensym and string->uninterned-symbol procedures generate 
fresh uninterned symbols that are not equal (according to eq?) 
to any previously interned or uninterned symbol. Uninterned 
symbols are useful as fresh tags that cannot be confused with 
any other value. |#

;; Examples:

(define s (gensym))
s
;; 'g42

(eq? s 'g42)

    #f
    > (eq? 'a (string->uninterned-symbol "a"))

    #f

#|     +Symbols in The Racket Reference provides more on symbols. |#
