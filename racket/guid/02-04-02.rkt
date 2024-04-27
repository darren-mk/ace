#lang racket/base

;; 2.4.2 Abbreviating quote with '

#| As you may have guessed, you can abbreviate a use 
of quote by just putting ' in front of a form to 
quote: |#

'(1 2 3)
;; '(1 2 3)

'road
;; 'road

'((1 2 3) road ("a" "b" "c"))
;; '((1 2 3) road ("a" "b" "c"))

#| In the documentation, ' within an expression is 
printed in green along with the form after it, since 
the combination is an expression that is a constant. 
In DrRacket, only the ' is colored green. DrRacket 
is more precisely correct, because the meaning of 
quote can vary depending on the context of an 
expression. In the documentation, however, we 
routinely assume that standard bindings are in scope, 
and so we paint quoted forms in green for extra 
clarity. |#

#| A ' expands to a quote form in quite a literal way. 
You can see this if you put a ' in front of a form 
that has a ': |#

(car ''road)
;; 'quote

(car '(quote road))
;; 'quote

#| The ' abbreviation works in output as well as 
input. The REPL’s printer recognizes the symbol 
'quote as the first element of a two-element list 
when printing output, in which case it uses ’ to 
print the output: |#

(quote (quote road))
;; ''road

'(quote road)
;; ''road

''road
;; ''road
