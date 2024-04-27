#lang racket/base

;; https://4clojure.oxal.org/#/problem/34

;; 1
(define (make-range beg end l)
  (if (= beg end)
      (reverse l)
      (make-range (+ beg 1)
                  end
                  (cons beg l))))
(define (f1 beg end)
  (make-range beg end '()))
(equal? (f1 1 4) '(1 2 3)) ;; #t
(equal? (f1 -2 2) '(-2 -1 0 1)) ;; #t
(equal? (f1 5 8) '(5 6 7)) ;; #t
