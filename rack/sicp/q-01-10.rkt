#lang sicp

;; https://mitpress.mit.edu/sites/default/files/sicp/full-text/book/book-Z-H-11.html#%_sec_1.2

(define (A x y)
  (cond ((= y 0) 0)
        ((= x 0) (* 2 y))
        ((= y 1) 2)
        (else (A (- x 1)
                 (A x (- y 1))))))

;; what are values of following expressions?
(A 1 10) ;; 1024
(A 2 4) ;; 65536
(A 3 3) ;; 65536

;; give concise mathematical definitions
(define (f n) (A 0 n))
;; is defined as f(n) = 2 * n
;; is equivalent to
(define (f-eq n) (* 2 n))
;; check
(f 3) ;; 6
(f-eq 3) ;; 6
(define (g n) (A 1 n))
;; ?
(define (h n) (A 2 n))
;; ?
(define (k n) (* 5 n n))
;; is defined as f(n)=5*n^2
;; is already simplified.
