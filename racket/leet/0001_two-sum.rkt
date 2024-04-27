;; https://leetcode.com/problems/two-sum

#lang racket/base

(require racket/contract
         racket/hash)

;; 1
(define (iter nums target i compls)
  (let* ([n (list-ref nums i)]
         [t (- target n)])    
    (if (hash-has-key? compls n)
        (list (hash-ref compls n) i)
        (iter nums target (add1 i)
              (if (hash-has-key? compls t)
                  compls                  
                  (hash-union compls
                              (hash t i)))))))
(define/contract (two-sum nums target)
  (-> (listof exact-integer?)
      exact-integer?
      (listof exact-integer?))
  (iter nums target 0 (hash)))
(two-sum '(2 7 11 15) 9) ;; '(0 1)
(two-sum '(3 2 4) 6) ;; '(1 2)
(two-sum '(1 1 3 3) 6) ;; '(0 1)
(two-sum '(1 1 1 1 1 4 1 1 1 1 1 7 1 1 1 1 1) 11) ;; '(5 11)
#| Runtime: 482 ms, faster than 25.93% of Racket online submissions for Two Sum.
Memory Usage: 127 MB, less than 22.22% of Racket online submissions for Two Sum. |#
