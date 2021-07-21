#lang sicp

;; https://mitpress.mit.edu/sites/default/files/sicp/full-text/book/book-Z-H-11.html#%_sec_1.2

;; 1
;; recursive
(define (f-rec n)
  (if (< n 3)
      0
      (+ (* 1 (f-rec (- n 1)))
         (* 2 (f-rec (- n 2)))
         (* 3 (f-rec (- n 3))))))
;; iterative
;; http://community.schemewiki.org/?sicp-ex-1.11
;; ?

