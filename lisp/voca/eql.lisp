;; https://www.cs.cmu.edu/Groups/AI/html/cltl/clm/node74.html

#|
The eql predicate is true if its arguments are eq, or if they 
are numbers of the same type with the same value, or if they 
are character objects that represent the same character. 
For example: 
|#

(eql 'a 'b)
;; NIL

(eql 'a 'a)
;; T

(eql 3 3)
;; T

(eql 3 3.0)
;; NIL

(eql 3.0 3.0)
;; T

(eql #c(3 -4) #c(3 -4))
;; T

(eql #c(3 -4.0) #c(3 -4))
;; NIL

(eql (cons 'a 'b) (cons 'a 'c))
;; NIL

(eql (cons 'a 'b) (cons 'a 'b))
;; NIL

(eql '(a . b) '(a . b))
;; NIL

(progn (setq x (cons 'a 'b)) (eql x x))
;; T

(progn (setq x '(a . b)) (eql x x))
;; T

(eql #\A #\A)
;; T

(eql "Foo" "Foo")
;; NIL

(eql "Foo" (copy-seq "Foo"))
;; NIL

(eql "FOO" "foo")
;; NIL

#| Normally (eql 1.0s0 1.0d0) would be false, under the assumption 
that 1.0s0 and 1.0d0 are of distinct data types. However, 
implementations that do not provide four distinct floating-point 
formats are permitted to ``collapse'' the four formats into some 
smaller number of them; in such an implementation (eql 1.0s0 1.0d0) 
might be true. The predicate = will compare the values of two 
numbers even if the numbers are of different types.

If an implementation supports positive and negative zeros as distinct 
values (as in the IEEE proposed standard floating-point format), 
then (eql 0.0 -0.0) will be false. Otherwise, when the syntax -0.0 
is read it will be interpreted as the value 0.0, and so (eql 0.0 -0.0) 
will be true. The predicate = differs from eql in that (= 0.0 -0.0) 
will always be true, because = compares the mathematical values of 
its operands, whereas eql compares the representational values, so 
to speak.

Two complex numbers are considered to be eql if their real parts are 
eql and their imaginary parts are eql. For example, 
(eql #C(4 5) #C(4 5)) is true and 
(eql #C(4 5) #C(4.0 5.0)) is false. 
Note that while 
(eql #C(5.0 0.0) 5.0) is false, 
(eql #C(5 0) 5) is true. 
In the case of 
(eql #C(5.0 0.0) 5.0) the two arguments are of different types and 
so cannot satisfy eql; that's all there is to it. In the case of 
(eql #C(5 0) 5), however, #C(5 0) is not a complex number but is 
always automatically reduced by the rule of complex canonicalization 
to the integer 5, just as the apparent ratio 20/4 is always 
simplified to 5.

The case of (eql "Foo" "Foo") is discussed above in the description 
of eq. While eql compares the values of numbers and characters, 
it does not compare the contents of strings. To compare the characters 
of two strings, one should use equal, equalp, string=, or string-equal.

Compatibility note: The Common Lisp function eql is similar to the 
Interlisp function eqp. However, eql considers 3 and 3.0 to be 
different, whereas eqp considers them to be the same; eqp behaves 
like the Common Lisp = function, not like eql, when both arguments 
are numbers. 
|#
