#lang racket/base

(require racket/contract) 
 
(define/contract (my-pow x n)
  (-> flonum? exact-integer? flonum?)
  (define (pow v x n)
    (let* ((direction? (< 0 n))
           (positioned-x (if direction? x (/ 1 x)))
           (next-n (if direction? (- n 1) (+ n 1))))
      (if (= n 0)
          v
          (pow (* v positioned-x) x next-n))))
  (pow 1 x n))

(define (pow v x n)
  (let* ((direction? (< 0 n))
         (positioned-x (if direction? x (/ 1 x)))
         (next-n (if direction? (- n 1) (+ n 1))))
    (if (= n 0)
        v
        (pow (* v positioned-x) x next-n))))
