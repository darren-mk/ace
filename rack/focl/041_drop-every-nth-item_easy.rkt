#lang racket/base

(require racket/stream
         threading)

;; https://4clojure.oxal.org/#/problem/41

;; 1
;; make pairs with index starting at 1
;; filter out all items whose index is a multiple of n
;; get the value from the result pairs
(define (f1 l n)
  (map cdr
       (filter (lambda (p)
                 (not (zero? (remainder (car p) n))))
               (map cons
                    (stream->list
                     (in-range 1
                               (add1 (length l))))
                    l))))
(equal? (f1 '(1 2 3 4 5 6 7 8) 3) '(1 2 4 5 7 8)) ;; #t
(equal? (f1 '(#:a #:b #:c #:d #:e #:f) 2) '(#:a #:c #:e)) ;; #t
(equal? (f1 '(1 2 3 4 5 6) 4) '(1 2 3 5 6)) ;; #t

;; 2
;; prettified solution 1 by threading
(define (f2 l n)
  (map cdr
       (filter (lambda (p)
                 (~> p
                     car
                     (remainder n)
                     zero?
                     not))
               (map cons
                    (~>> l
                         length
                         add1
                         (in-range 1)
                         stream->list)
                    l))))
(equal? (f2 '(1 2 3 4 5 6 7 8) 3) '(1 2 4 5 7 8)) ;; #t
(equal? (f2 '(#:a #:b #:c #:d #:e #:f) 2) '(#:a #:c #:e)) ;; #t
(equal? (f2 '(1 2 3 4 5 6) 4) '(1 2 3 5 6)) ;; #t
