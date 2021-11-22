;; https://www.cs.cmu.edu/Groups/AI/html/cltl/clm/node74.html

#| Two objects are equalp if they are equal; if they are 
characters and satisfy char-equal, which ignores alphabetic 
case and certain other attributes of characters; if they are 
numbers and have the same numerical value, even if they are of 
different types; or if they have components that are all equalp.
Objects that have components are equalp if they are of the same 
type and corresponding components are equalp. This test is 
implemented in a recursive manner and may fail to terminate for 
circular structures. For conses, equalp is defined recursively 
as the two car's being equalp and the two cdr's being equalp.
Two arrays are equalp if and only if they have the same number 
of dimensions, the dimensions match, and the corresponding 
components are equalp. The specializations need not match; for 
example, a string and a general array that happens to contain 
the same characters will be equalp (though definitely not equal). 
If either argument has a fill pointer, the fill pointer limits 
the number of elements examined by equalp. Because equalp 
performs element-by-element comparisons of strings and ignores 
the alphabetic case of characters, case distinctions are 
therefore also ignored when equalp compares strings.
Two symbols can be equalp only if they are eq, that is, the same 
identical object.
change_begin
X3J13 voted in June 1989 (EQUAL-STRUCTURE)   to specify that 
equalp compares components of hash tables (see below), and to 
clarify that otherwise equalp never recursively descends any 
structure or data type other than the ones explicitly described 
above: conses, arrays 
(including bit-vectors and strings), and pathnames. Numbers are 
compared for numerical equality (see =), characters are compared 
as if by char-equal, and all other data objects are compared as if 
by eq.
Two hash tables are considered the same by equalp if and only if 
they satisfy a four-part test:
They must be of the same kind; that is, equivalent :test arguments 
were given to make-hash-table when the two hash tables were created.
They must have the same number of entries (see hash-table-count).
For every entry (key1, value1) in one hash table there must be a 
corresponding entry (key2, value2) in the other, such that key1 and 
key2 are considered to be the same by the :test function associated 
with the hash tables.
For every entry (key1, value1) in one hash table and its 
corresponding entry (key2, value2) in the other, such that key1 and 
key2 are the same, equalp must be true of value1 and value2. 
The four parts of this test are carried out in the order shown, and 
if some part of the test fails, equalp returns nil and the other 
parts of the test are not attempted.
If equalp must compare two structures and the defstruct definition 
for one used the :type option and the other did not, then equalp 
returns nil.
If equalp must compare two structures and neither defstruct 
definition used the :type option, then equalp returns t if and only 
if the structures have the same type (that is, the same defstruct 
name) and the values of all corresponding slots (slots having the 
same name) are equalp.
As part of the X3J13 discussion of this issue the following 
observations were made. Object equality is not a concept for which 
there is a uniquely determined correct algorithm. The 
appropriateness of an equality predicate can be judged only in 
the context of the needs of some particular program. Although 
these functions take any type of argument and their names sound 
very generic, equal and equalp are not appropriate for every 
application. Any decision to use or not use them should be 
determined by what they are documented to do rather than by any 
abstract characterization of their function. If neither equal 
nor equalp is found to be appropriate in a particular situation, 
programmers are encouraged to create another operator that is 
appropriate rather than blame equal or equalp for ``doing the 
wrong thing.''
Note that one consequence of the vote to change the rules of 
floating-point contagion (CONTAGION-ON-NUMERICAL-COMPARISONS)   
(described in section 12.1) is to make equalp a true equivalence 
relation on numbers.
change_end|#

(equalp 'a 'b)
;; NIL

(equalp 'a 'a)
;; T

(equalp 3 3)
;; T

(equalp 3 3.0)
;; T

(equalp 3.0 3.0)
;; T

(equalp #c(3 -4) #c(3 -4))
;; T

(equalp #c(3 -4.0) #c(3 -4))
;; T

(equalp (cons 'a 'b) (cons 'a 'c))
;; NIL

(equalp (cons 'a 'b) (cons 'a 'b))
;; T

(equalp '(a . b) '(a . b))
;; T

(progn (setq x (cons 'a 'b)) (equalp x x))
;; T

(progn (setq x '(a . b)) (equalp x x))
;; T
;; caught WARNING condition

(equalp #\A #\A)
;; T

(equalp "Foo" "Foo")
;; T

(equalp "Foo" (copy-seq "Foo"))
;; T

(equalp "FOO" "foo")
;; T
