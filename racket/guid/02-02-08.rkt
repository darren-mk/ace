#lang racket/base

(require racket/string)

;; 2.2.8 Local Binding with define, let, and let*

;; It’s time to retract another simplification in
;; our grammar of Racket. In the body of a function,
;; definitions can appear before the body expressions:

;; +Internal Definitions (later in this guide) explains
;; more about local (internal) definitions.

;; ( define ( ‹id› ‹id›* ) ‹definition›* ‹expr›+ )
;; ( lambda ( ‹id›* ) ‹definition›* ‹expr›+ )

;; Definitions at the start of a function body are
;; local to the function body.

;; Examples:

(define (converse s)
  (define (starts? s2) ; local to converse
    (define spaced-s2 (string-append s2 " ")) ; local to starts?
    (string-prefix? s spaced-s2))
  (cond
    [(starts? "hello") "hi!"]
    [(starts? "goodbye") "bye!"]
    [else "huh?"]))

(converse "hello world")
;; "hi!"

(converse "hellonearth")
;; "huh?"

(converse "goodbye friends")
;; "bye!"

(converse "urp")
;; "huh?"

starts? ; outside of converse, so...
;; starts?: undefined;
;; cannot reference an identifier before its definition
;; in module: top-level

;; Another way to create local bindings is the let
;; form. An advantage of let is that it can be used
;; in any expression position. Also, let binds many
;; identifiers at once, instead of requiring a separate
;; define for each identifier.

;; +Internal Definitions (later in this guide) explains
;; more about let and let*.

;; ( let ( {[ ‹id› ‹expr› ]}* ) ‹expr›+ )

;; Each binding clause is an ‹id› and an ‹expr› surrounded
;; by square brackets, and the expressions after the
;; clauses are the body of the let. In each clause, the
;; ‹id› is bound to the result of the ‹expr› for use in the body.

(let ([x (random 4)]
      [o (random 4)])
  (cond
    [(> x o) "X wins"]
    [(> o x) "O wins"]
    [else "cat's game"]))
;; "O wins"

;; The bindings of a let form are available only in the
;; body of the let, so the binding clauses cannot refer
;; to each other. The let* form, in contrast, allows later
;; clauses to use earlier bindings:

(let* ([x (random 4)]
       [o (random 4)]
       [diff (number->string (abs (- x o)))])
  (cond
    [(> x o) (string-append "X wins by " diff)]
    [(> o x) (string-append "O wins by " diff)]
    [else "cat's game"]))
;; "X wins by 2"
