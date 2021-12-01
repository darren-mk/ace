#lang racket/base

(require threading)

;; https://4clojure.oxal.org/#/problem/20

;; 1
;; recur the function with cdr
;; until just two elements are left.
(define (f1 coll)
  (if (equal? (length coll) 2)
      (car coll)
      (f1 (cdr coll))))
(equal? (f1 (list 1 2 3 4 5)) 4) ;; #t
(equal? (f1 '("a" "b" "c")) "b") ;; #t
(equal? (f1 '((1 2) (3 4))) '(1 2)) ;; #t

;; 2
;; find the length of the list and
;; reference the list by the length minus 2.
(define (f2 l)
  (list-ref 
   l
   (- (length l) 2)))
(equal? (f2 (list 1 2 3 4 5)) 4) ;; #t
(equal? (f2 '("a" "b" "c")) "b") ;; #t
(equal? (f2 '((1 2) (3 4))) '(1 2)) ;; #t

;; 3
;; reverse the list
;; and then cdr and car
(define (f3 l)
  (~> l
      reverse
      cdr
      car))
(equal? (f3 (list 1 2 3 4 5)) 4) ;; #t
(equal? (f3 '("a" "b" "c")) "b") ;; #t
(equal? (f3 '((1 2) (3 4))) '(1 2)) ;; #t
