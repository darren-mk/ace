#lang racket/base

;; 2.2.6 Function Calls, Again

;; In our earlier grammar of function calls,
;; we oversimplified. The actual syntax of
;; a function call allows an arbitrary expression
;; for the function, instead of just an ‹id›:

;; +Function Calls (later in this guide) explains
;; more about function calls.

;; ( ‹expr› ‹expr›* )

;; The first ‹expr› is often an ‹id›, such as
;; string-append or +, but it can be anything that
;; evaluates to a function. For example, it can be
;; a conditional expression:

(define (double v)
  ((if (string? v)
       string-append
       +)
   v
   v))

(double "mnah")
;; "mnahmnah"

(double 5)
;; 10

;; Syntactically, the first expression in a function
;; call could even be a number — but that leads to
;; an error, since a number is not a function.

;; (1 2 3 4)
;; application: not a procedure;
;; expected a procedure that can be applied to arguments
;; given: 1

;; When you accidentally omit a function name or when you
;; use extra parentheses around an expression, you’ll most
;; often get an “expected a procedure” error like this one.
