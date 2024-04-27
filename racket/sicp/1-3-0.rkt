#|

1.3  Formulating Abstractions with Higher-Order Procedures

We have seen that procedures are, in effect,
abstractions that describe compound operations
on numbers independent of the particular numbers.
For example, when we

(define (cube x)
  (* x x x))

we are not talking about the cube of
a particular number, but rather about a method
for obtaining the cube of any number.
Of course we could get along without
ever defining this procedure,
by always writing expressions such as

(* 3 3 3)
(* x x x)
(* y y y)        

and never mentioning cube explicitly.
This would place us at a serious disadvantage,
forcing us to work always at the level
of the particular operations that happen
to be primitives in the language
(multiplication, in this case) rather than
in terms of higher-level operations.
Our programs would be able to compute cubes,
but our language would lack the ability
to express the concept of cubing.
One of the things we should demand from
a powerful programming language is the ability
to build abstractions by assigning names
to common patterns and then to work in terms of
the abstractions directly. Procedures provide this ability.
This is why all but the most primitive programming languages
include mechanisms for defining procedures.

Yet even in numerical processing we will be severely limited
in our ability to create abstractions if we are restricted
to procedures whose parameters must be numbers.
Often the same programming pattern will be used
with a number of different procedures.
To express such patterns as concepts,
we will need to construct procedures that can
accept procedures as arguments or return procedures as values.
Procedures that manipulate procedures are
called higher-order procedures.
This section shows how higher-order procedures can
serve as powerful abstraction mechanisms,
vastly increasing the expressive power of our language.

|#
