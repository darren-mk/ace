;; https://www.cs.cmu.edu/Groups/AI/html/cltl/clm/node74.html

#|
(eq x y) is true if and only if x and y are 
the same identical object. 
(Implementationally, x and y are usually eq 
if and only if they address the same identical 
memory location.)
It should be noted that things that print the same 
are not necessarily eq to each other. Symbols 
with the same print name usually are eq to 
each other because of the use of the intern function. However, numbers with the same value need not be eq, 
and two similar lists are usually not eq. For example: 
|#

(eq 'a 'b)
;; NIL 

(eq 'a 'a)
;; T 

(eq 3 3)
;; T
;; might be true or false, depending on the implementation. 

(eq 3 3.0)
;; NIL  

(eq 3.0 3.0)
;; T
;; might be true or false, depending on the implementation. 

(eq #c(3 -4) #c(3 -4))
;; NIL
;; might be true or false, depending on the implementation. 

(eq #c(3 -4.0) #c(3 -4))
;; NIL

(eq (cons 'a 'b) (cons 'a 'c))
;; NIL

(eq (cons 'a 'b) (cons 'a 'b))
;; NIL

(eq '(a . b) '(a . b))
;; NIL

(progn (setq x (cons 'a 'b)) (eq x x))
;; T

(progn (setq x '(a . b)) (eq x x))
;; T

(eq #\A #\A)
;; T
;; might be true or false, depending on the implementation. 

(eq "Foo" "Foo")
;; NIL

(eq "Foo" (copy-seq "Foo"))
;; NIL

(eq "FOO" "foo")
;; NIL

#|
In Common Lisp, unlike some other Lisp dialects, 
the implementation is permitted to make ``copies'' 
of characters and numbers at any time. 
(This permission is granted because it allows 
tremendous performance improvements in many common
situations.) The net effect is that Common Lisp makes 
no guarantee that eq will be true even when both its 
arguments are ``the same thing'' if that thing is a 
character or number. For example:
|#

(let ((x 5)) (eq x x))
;; T
;; might be true or false.

#|
The predicate eql is the same as eq, except that if the 
arguments are characters or numbers of the same type then 
their values are compared. Thus eql tells whether two 
objects are conceptually the same, whereas eq tells whether 
two objects are implementationally identical. It is for 
this reason that eql, not eq, is the default comparison 
predicate for the sequence functions defined in chapter 14.
Implementation note: eq simply compares the two given pointers, 
so any kind of object that is represented in an ``immediate'' 
fashion will indeed have like-valued instances satisfy eq. 
In some implementations, for example, fixnums and characters 
happen to ``work.'' However, no program should depend on this, 
as other implementations of Common Lisp might not use an 
immediate representation for these data types.
old_change_begin
An additional problem with eq is that the implementation is 
permitted to ``collapse'' constants (or portions thereof) appearing 
in code to be compiled if they are equal. An object is considered 
to be a constant in code to be compiled if it is a self-evaluating 
form or is contained in a quote form. This is why (eq "Foo" "Foo") 
might be true or false; in interpreted code it would normally be false, 
because reading in the form (eq "Foo" "Foo") would construct distinct 
strings for the two arguments to eq, but the compiler might choose to 
use the same identical string or two distinct copies as the two 
arguments in the call to eq. Similarly, (eq '(a . b) '(a . b)) might 
be true or false, depending on whether the constant conses appearing
in the quote forms were collapsed by the compiler. However, 
(eq (cons 'a 'b) (cons 'a 'b)) is always false, because every distinct 
call to the cons function necessarily produces a new and distinct cons. 
|#
