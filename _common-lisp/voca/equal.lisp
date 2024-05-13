;;


#| The equal predicate is true if its arguments are structurally 
similar (isomorphic) objects. A rough rule of thumb is that two 
objects are equal if and only if their printed representations 
are the same.
Numbers and characters are compared as for eql. Symbols are 
compared as for eq. This method of comparing symbols can violate 
the rule of thumb for equal and printed representations, but only 
in the infrequently occurring case of two distinct symbols with 
the same print name.
Certain objects that have components are equal if they are of 
the same type and corresponding components are equal. This test 
is implemented in a recursive manner and may fail to terminate 
for circular structures.
For conses, equal is defined recursively as the two car's being 
equal and the two cdr's being equal.
Two arrays are equal only if they are eq, with one exception: 
strings and bit-vectors are compared element-by-element. If either 
argument has a fill pointer, the fill pointer limits the number 
of elements examined by equal. Uppercase and lowercase letters in 
strings are considered by equal to be distinct. (In contrast, 
equalp ignores case distinctions in strings.)
Compatibility note: In Lisp Machine Lisp, equal ignores the 
difference between uppercase and lowercase letters in strings. 
This violates the rule of thumb about printed representations, 
however, which is very useful, especially to novices. It is also 
inconsistent with the treatment of single characters, which in 
Lisp Machine Lisp are represented as fixnums.
Two pathname objects are equal if and only if all the corresponding 
components (host, device, and so on) are equivalent. (Whether or 
not uppercase and lowercase letters are considered equivalent in 
strings appearing in components depends on the file name 
conventions of the file system.) Pathnames that are equal should 
be functionally equivalent.
change_begin
X3J13 voted in June 1989 (EQUAL-STRUCTURE)   to clarify that equal 
never recursively descends any structure or data type other than 
the ones explicitly described above: conses, bit-vectors, strings, 
and pathnames. Numbers and characters are compared as if by eql, 
and all other data objects are compared as if by eq.
change_end |#

(equal 'a 'b)
;; NIL

(equal 'a 'a)
;; T

(equal 3 3)
;; T

(equal 3 3.0)
;; NIL

(equal 3.0 3.0)
;; T

(equal #c(3 -4) #c(3 -4))
;; T

(equal #c(3 -4.0) #c(3 -4))
;; NIL

(equal (cons 'a 'b) (cons 'a 'c))
;; NIL

(equal (cons 'a 'b) (cons 'a 'b))
;; T

(equal '(a . b) '(a . b))
;; T

(progn (setq x (cons 'a 'b)) (equal x x))
;; T
;; caught WARNING condition

(progn (setq x '(a . b)) (equal x x))
;; T
;; caught WARNING condition

(equal #\A #\A)
;; T

(equal "Foo" "Foo")
;; T

(equal "Foo" (copy-seq "Foo"))
;; T

(equal "FOO" "foo")
;; NIL

#| To compare a tree of conses using eql (or any other desired 
predicate) on the leaves, use tree-equal. |# 
