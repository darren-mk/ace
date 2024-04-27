#lang racket

;; https://4clojure.oxal.org/#/problem/38

;; 1
;; sort the list and take the first.
(define (f1 . l)
  (first (sort l >)))
(= (f1 1 8 3 4) 8) ;; #t
(= (f1 30 20) 30) ;; #t
(= (f1 45 67 11) 67) ;; #t

;; 2
;; push maximum from zero to each arg.
(define (f2 . l)
  (define (iter l mx)
    (if (empty? l)
        mx
        (iter (rest l)
              (if (< mx (first l))
                  (first l)
                  mx))))
  (iter l 0)) 
(= (f2 1 8 3 4) 8) ;; #t
(= (f2 30 20) 30) ;; #t
(= (f2 45 67 11) 67) ;; #t
