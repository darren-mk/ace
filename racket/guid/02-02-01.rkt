#lang racket/base

;; A definition of the form
;; ( define ‹id› ‹expr› )
;; binds ‹id› to the result of ‹expr›, while
;; ( define ( ‹id› ‹id›* ) ‹expr›+ )
;; binds the first ‹id› to a function (also called a procedure)
;; that takes arguments as named by the remaining ‹id›s.
;; In the function case, the ‹expr›s are the body of the
;; function. When the function is called, it returns the
;; result of the last ‹expr›.

(define pie 3)
pie ;; 3

;; Under the hood, a function definition is really the same
;; as a non-function definition, and a function name does not
;; have to be used in a function call. A function is just
;; another kind of value, though the printed form is necessarily
;; less complete than the printed form of a number or string.

(define (piece s)
  (substring s 0 pie))
substring ;; #<procedure:substring>
piece ;; #<procedure:piece>
(piece "key lime") ;; key

;; A function definition can include multiple expressions
;; for the function’s body. In that case, only the value
;; of the last expression is returned when the function is
;; called. The other expressions are evaluated only for
;; some side-effect, such as printing.

(define (bake flavor)
  (printf "preheating oven...\n")
  (string-append flavor " pie"))

(bake "apple")
;; preheating oven...
;; "apple pie"

;; Racket programmers prefer to avoid side-effects, so a
;; definition usually has just one expression in its body.
;; It’s important, though, to understand that multiple
;; expressions are allowed in a definition body, because
;; it explains why the following nobake function fails
;; to include its argument in its result:

(define (nobake flavor)
  string-append flavor "jello")
(nobake "green")
;; "jello"

;; Within nobake, there are no parentheses around
;; string-append flavor "jello", so they are three separate
;; expressions instead of one function-call expression.
;; The expressions string-append and flavor are evaluated,
;; but the results are never used. Instead, the result of
;; the function is just the result of the final expression, "jello".
