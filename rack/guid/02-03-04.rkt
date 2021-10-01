#lang racket/base

(require racket/list)

;; 2.3.4 Recursion versus Iteration

;; The my-length and my-map examples demonstrate that iteration is just a special case of recursion. In many languages, it’s important to try to fit as many computations as possible into iteration form. Otherwise, performance will be bad, and moderately large inputs can lead to stack overflow. Similarly, in Racket, it is sometimes important to make sure that tail recursion is used to avoid O(n) space consumption when the computation is easily performed in constant space.

;; At the same time, recursion does not lead to particularly bad performance in Racket, and there is no such thing as stack overflow; you can run out of memory if a computation involves too much context, but exhausting memory typically requires orders of magnitude deeper recursion than would trigger a stack overflow in other languages. These considerations, combined with the fact that tail-recursive programs automatically run the same as a loop, lead Racket programmers to embrace recursive forms rather than avoid them.

;; Suppose, for example, that you want to remove consecutive duplicates from a list. While such a function can be written as a loop that remembers the previous element for each iteration, a Racket programmer would more likely just write the following:

(define (remove-dups l)
  (cond
    [(empty? l) empty]
    [(empty? (rest l)) l]
    [else
     (let ([i (first l)])
       (if (equal? i (first (rest l)))
           (remove-dups (rest l))
           (cons i (remove-dups (rest l)))))]))
(remove-dups (list "a" "b" "b" "b" "c" "c"))

    '("a" "b" "c")

;; In general, this function consumes O(n) space for an input list of length n, but that’s fine, since it produces an O(n) result. If the input list happens to be mostly consecutive duplicates, then the resulting list can be much smaller than O(n)—and remove-dups will also use much less than O(n) space! The reason is that when the function discards duplicates, it returns the result of a remove-dups call directly, so the tail-call “optimization” kicks in:

(remove-dups (list "a" "b" "b" "b" "b" "b"))
= (cons "a" (remove-dups (list "b" "b" "b" "b" "b")))
= (cons "a" (remove-dups (list "b" "b" "b" "b")))
= (cons "a" (remove-dups (list "b" "b" "b")))
= (cons "a" (remove-dups (list "b" "b")))
= (cons "a" (remove-dups (list "b")))
= (cons "a" (list "b"))
= (list "a" "b")
