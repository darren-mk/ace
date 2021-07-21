#lang sicp

;; https://mitpress.mit.edu/sites/default/files/sicp/full-text/book/book-Z-H-11.html#%_sec_1.2

;; 1
;; https://billthelizard.blogspot.com/2009/11/sicp-exercise-112-pascals-triangle.html
(define (f1 row col)
  (cond ((or (= col 0) (= row col)) 1)
        (else (+ (f1 (dec row) col)
                 (f1 (dec row) (dec col))))))
(f1 5 3) ;; 10
