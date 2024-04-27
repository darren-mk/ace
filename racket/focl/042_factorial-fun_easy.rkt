#lang racket

;; https://4clojure.oxal.org/#/problem/42

;; 1
(define (f1 x)
  (apply *
         (stream->list
          (in-range 1 (add1 x)))))
(= (f1 1) 1) ;; #t
(= (f1 3) 6) ;; #t
(= (f1 5) 120) ;; #t
(= (f1 8) 40320) ;; #t

;; 2
(define (f2 x)
  (if (<= x 1)
      1
      (* x (f2 (sub1 x)))))
(= (f2 1) 1) ;; #t
(= (f2 3) 6) ;; #t
(= (f2 5) 120) ;; #t
(= (f2 8) 40320) ;; #t
