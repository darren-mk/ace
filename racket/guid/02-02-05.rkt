#lang racket/base

(require racket/string)

;; 2.2.5 Conditionals with if, and, or, and cond

;; The next simplest kind of expression is an
;; if conditional:

;; ( if ‹expr› ‹expr› ‹expr› )

;; +Conditionals (later in this guide) explains
;; more about conditionals.

;; The first ‹expr› is always evaluated. If it
;; produces a non-#f value, then the second ‹expr›
;; is evaluated for the result of the whole if
;; expression, otherwise the third ‹expr› is
;; evaluated for the result.

;; Example:

(if (> 2 3)
    "2 is bigger than 3"
    "2 is smaller than 3")
;; "2 is smaller than 3"

(define (reply s)
  (if (string-prefix? s "hello ")
      "hi!"
      "huh?"))
(reply "hello racket")
;; "hi!"
(reply "λx:(μα.α→α).xx")
;; "huh?"

;; Complex conditionals can be formed by nesting
;; if expressions. For example, in the previous
;; reply example, the input must be a string because
;; string-prefix? would error when given non-strings.
;; You can remove this restriction by adding another
;; if to check first if the input is a string:

(define (reply-non-string s)
  (if (string? s)
      (if (string-prefix? s "hello ")
          "hi!"
          "huh?")
      "huh?"))

;; Instead of duplicating the "huh?" case, this
;; function is better written as

(define (reply-non-string s)
  (if (if (string? s)
          (string-prefix? s "hello ")
          #f)
      "hi!"
      "huh?"))

;; but these kinds of nested ifs are difficult to
;; read. Racket provides more readable shortcuts
;; through the and and or forms:

;; +Combining Tests: and and or (later in this guide)
;; explains more about and and or.

;; ( and ‹expr›* )
;; ( or ‹expr›* )

;; The and form short-circuits: it stops and returns
;; #f when an expression produces #f, otherwise it
;; keeps going. The or form similarly short-circuits
;; when it encounters a true result.

;; Examples:

(define (reply-non-string s)
  (if (and (string? s)
           (string-prefix? s "hello "))
      "hi!"
      "huh?"))

(reply-non-string "hello racket")
;; "hi!"

(reply-non-string 17)
;; "huh?"

;; Note that in the above grammar, the and and or forms
;; work with any number of expressions.

;; Examples:

(define (reply-only-enthusiastic s)
  (if (and (string? s)
           (string-prefix? s "hello ")
           (string-suffix? s "!"))
      "hi!"
      "huh?"))

(reply-only-enthusiastic "hello racket!")
;; "hi!"

(reply-only-enthusiastic "hello racket")
;; "huh?"

;; Another common pattern of nested ifs involves
;; a sequence of tests, each with its own result:

(define (reply-more s)
  (if (string-prefix? s "hello ")
      "hi!"
      (if (string-prefix? s "goodbye ")
          "bye!"
          (if (string-suffix? s "?")
              "I don't know"
              "huh?"))))

;; The shorthand for a sequence of tests is
;; the cond form:

;; +Chaining Tests: cond (later in this guide)
;; explains more about cond.

;; ( cond {[ ‹expr› ‹expr›* ]}* )

;; A cond form contains a sequence of clauses between
;; square brackets. In each clause, the first ‹expr›
;; is a test expression. If it produces true, then
;; the clause’s remaining ‹expr›s are evaluated, and
;; the last one in the clause provides the answer for
;; the entire cond expression; the rest of the clauses
;; are ignored. If the test ‹expr› produces #f, then
;; the clause’s remaining ‹expr›s are ignored, and
;; evaluation continues with the next clause. The last
;; clause can use else as a synonym for a #t test expression.

;; Using cond, the reply-more function can be more clearly
;; written as follows:

(define (reply-more s)
  (cond
    [(string-prefix? s "hello ")
     "hi!"]
    [(string-prefix? s "goodbye ")
     "bye!"]
    [(string-suffix? s "?")
     "I don't know"]
    [else "huh?"]))

(reply-more "hello racket")
;; "hi!"

(reply-more "goodbye cruel world")
;; "bye!"

(reply-more "what is your favorite color?")
;; "I don't know"

(reply-more "mine is lime green")
;; "huh?"

;; The use of square brackets for cond clauses is
;; a convention. In Racket, parentheses and square
;; brackets are actually interchangeable, as long as
;; ( is matched with ) and [ is matched with ]. Using
;; square brackets in a few key places makes Racket
;; code even more readable.
