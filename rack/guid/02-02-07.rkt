#lang racket/base

;; 2.2.7 Anonymous Functions with lambda

;; Programming in Racket would be tedious if
;; you had to name all of your numbers. Instead of
;; writing (+ 1 2), you’d have to write

;; +Functions: lambda (later in this guide) explains
;; more about lambda.

(define a 1)
(define b 2)
(+ a b)
;; 3

;; It turns out that having to name all your functions
;; can be tedious, too. For example, you might have
;; a function twice that takes a function and an argument.
;; Using twice is convenient if you already have a name
;; for the function, such as sqrt:

(define (twice f v)
  (f (f v)))

(twice sqrt 16)
;; 2

;; If you want to call a function that is not yet defined,
;; you could define it, and then pass it to twice:

(define (louder s)
  (string-append s "!"))

(twice louder "hello")
;; "hello!!"

;; But if the call to twice is the only place where
;; louder is used, it’s a shame to have to write
;; a whole definition. In Racket, you can use
;; a lambda expression to produce a function directly.
;; The lambda form is followed by identifiers for
;; the function’s arguments, and then the function’s
;; body expressions:

;; ( lambda ( ‹id›* ) ‹expr›+ )

;; Evaluating a lambda form by itself produces a function:

(lambda (s) (string-append s "!"))
;; #<procedure>

;; Using lambda, the above call to twice can be
;; re-written as

(twice (lambda (s) (string-append s "!"))
       "hello")
;; "hello!!"

(twice (lambda (s) (string-append s "?!"))
       "hello")
;; "hello?!?!"

;; Another use of lambda is as a result for
;; a function that generates functions:

(define (make-add-suffix s2)
  (lambda (s) (string-append s s2)))

(twice (make-add-suffix "!") "hello")
;; "hello!!"

(twice (make-add-suffix "?!") "hello")
;; "hello?!?!"

(twice (make-add-suffix "...") "hello")
;; "hello......"

;; Racket is a lexically scoped language, which means
;; that s2 in the function returned by make-add-suffix
;; always refers to the argument for the call that
;; created the function. In other words, the
;; lambda-generated function “remembers” the right s2:

(define louder
  (make-add-suffix "!"))

(define less-sure
  (make-add-suffix "?"))

(twice less-sure "really")
;; "really??"

(twice louder "really")
;; "really!!"

;; We have so far referred to definitions of the form
;; (define ‹id› ‹expr›) as “non-function definitions.”
;; This characterization is misleading, because the
;; ‹expr› could be a lambda form, in which case the
;; definition is equivalent to using the “function”
;; definition form. For example, the following two
;; definitions of louder are equivalent:

(define (louder s)
  (string-append s "!"))

(define louder
  (lambda (s)
    (string-append s "!")))

louder
;; #<procedure:louder>

;; Note that the expression for louder in the second
;; case is an “anonymous” function written with lambda,
;; but, if possible, the compiler infers a name, anyway,
;; to make printing and error reporting as informative
;; as possible.
