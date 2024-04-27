;; https://www.geeksforgeeks.org/linear-search/

#lang racket/base

(require racket/list)

;; 1
(define (linear-search-01 arr x)
  (if (null? arr)
      null
      (if (equal? (car arr) x)
          (length arr)
          (linear-search-01 (cdr arr) x))))
(linear-search-01 (range 10000000) 9999995)
;; 5
(time (linear-search-01 (range 10000000) 9999995))
;; cpu time: 607 real time: 614 gc time: 404
