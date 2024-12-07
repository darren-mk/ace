;; https://gigamonkeys.com/book/collections.html

#| MAKE-ARRAY is more general than VECTOR since you can use it 
to create arrays of any dimensionality as well as both fixed-size 
and resizable vectors. The one required argument to MAKE-ARRAY is 
a list containing the dimensions of the array. Since a vector is 
a one-dimensional array, this list will contain one number, the 
size of the vector. As a convenience, MAKE-ARRAY will also accept 
a plain number in the place of a one-item list. With no other 
arguments, MAKE-ARRAY will create a vector with uninitialized 
elements that must be set before they can be accessed.3 To create 
a vector with the elements all set to a particular value, you 
can pass an :initial-element argument. Thus, to make a 
five-element vector with its elements initialized to NIL, you 
can write the following: |#

(make-array 5 :initial-element nil)
;; #(NIL NIL NIL NIL NIL)

(MAKE-ARRAY 3 :initial-element 1)
;; #(1 1 1)

#| MAKE-ARRAY is also the function to use to make a resizable 
vector. A resizable vector is a slightly more complicated object 
than a fixed-size vector; in addition to keeping track of the 
memory used to hold the elements and the number of slots 
available, a resizable vector also keeps track of the number 
of elements actually stored in the vector. This number is 
stored in the vector's fill pointer, so called because it's 
the index of the next position to be filled when you add an 
element to the vector.

To make a vector with a fill pointer, you pass MAKE-ARRAY 
a :fill-pointer argument. For instance, the following call 
to MAKE-ARRAY makes a vector with room for five elements; 
but it looks empty because the fill pointer is zero: |#

(make-array 5 :fill-pointer 0)
;; #()

(make-array 3 :fill-pointer 0 :initial-element 'a)
;; #()

#| To add an element to the end of a resizable vector, you 
can use the function VECTOR-PUSH. It adds the element at 
the current value of the fill pointer and then increments 
the fill pointer by one, returning the index where the new 
element was added. The function VECTOR-POP returns the most 
recently pushed item, decrementing the fill pointer in the 
process. |#

(defparameter *x* (make-array 5 :fill-pointer 0))
;; *X*

(vector-push 'a *x*)
;; 0

*x*
;; #(A)

(vector-push 'b *x*)
;; 1

*x*
;; #(A B)

(vector-push 'c *x*)
;; 2

*x*
;; #(A B C)

(vector-pop *x*)
;; C

*x*
;; #(A B)

(vector-pop *x*)
;; B

*x*
;; #(A)

(vector-pop *x*)
;; A

*x*
;; #()

#| However, even a vector with a fill pointer isn't completely 
resizable. The vector *x* can hold at most five elements. To 
make an arbitrarily resizable vector, you need to pass 
MAKE-ARRAY another keyword argument: :adjustable. |#

(make-array 5 :fill-pointer 0 :adjustable t) ;; #()

#| This call makes an adjustable vector whose underlying memory 
can be resized as needed. To add elements to an adjustable
 vector, you use VECTOR-PUSH-EXTEND, which works just like 
VECTOR-PUSH except it will automatically expand the array if 
you try to push an element onto a full vector--one whose fill 
pointer is equal to the size of the underlying storage.4 |#
