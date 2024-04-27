#lang racket/base

(require racket/list)

;; 2.3.3 Tail Recursion

;; Both the my-length and my-map functions run in O(n)
;; space for a list of length n. This is easy to see by
;; imagining how (my-length (list "a" "b" "c")) must
;; evaluate:

;; (my-length (list "a" "b" "c"))
;; = (+ 1 (my-length (list "b" "c")))
;; = (+ 1 (+ 1 (my-length (list "c"))))
;; = (+ 1 (+ 1 (+ 1 (my-length (list)))))
;; = (+ 1 (+ 1 (+ 1 0)))
;; = (+ 1 (+ 1 1))
;; = (+ 1 2)
;; = 3

;; For a list with n elements, evaluation will stack
;; up n (+ 1 ...) additions, and then finally add them
;; up when the list is exhausted.

;; You can avoid piling up additions by adding along
;; the way. To accumulate a length this way, we need
;; a function that takes both a list and the length of
;; the list seen so far; the code below uses a local
;; function iter that accumulates the length in an
;; argument len:

(define (my-length lst)
  ;; local function iter:
  (define (iter lst len)
    (cond
      [(empty? lst) len]
      [else (iter (rest lst) (+ len 1))]))
  ; body of my-length calls iter:
  (iter lst 0))

;; Now evaluation looks like this:

(my-length (list "a" "b" "c"))
;; = (iter (list "a" "b" "c") 0)
;; = (iter (list "b" "c") 1)
;; = (iter (list "c") 2)
;; = (iter (list) 3)
;; 3

;; The revised my-length runs in constant space, just
;; as the evaluation steps above suggest. That is, when
;; the result of a function call, like
;; (iter (list "b" "c") 1), is exactly the result of
;; some other function call, like (iter (list "c") 2),
;; then the first one doesn’t have to wait around for
;; the second one, because that takes up space for no
;; good reason.

;; This evaluation behavior is sometimes called
;; tail-call optimization, but it’s not merely an
;; “optimization” in Racket; it’s a guarantee about
;; the way the code will run. More precisely, an
;; expression in tail position with respect to another
;; expression does not take extra computation space
;; over the other expression.

;; In the case of my-map, O(n) space complexity is
;; reasonable, since it has to generate a result of
;; size O(n). Nevertheless, you can reduce the constant
;; factor by accumulating the result list. The only
;; catch is that the accumulated list will be
;; backwards, so you’ll have to reverse it at the
;; very end:

;; Attempting to reduce a constant factor like this
;; is usually not worthwhile, as discussed below.

(define (my-map-1 f lst)
  (define (iter lst backward-result)
    (cond
      [(empty? lst) (reverse backward-result)]
      [else (iter (rest lst)
                  (cons (f (first lst))
                        backward-result))]))
  (iter lst empty))

;; It turns out that if you write

(define (my-map-2 f lst)
  (for/list ([i lst])
    (f i)))

;; then the for/list form in the function is expanded ;; to essentially the same code as the iter local
;; definition and use. The difference is merely
;; syntactic convenience.
