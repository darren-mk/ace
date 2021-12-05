;; https://4clojure.oxal.org/#/problem/81

#lang racket

(require racket/set)

;; 1
(define (f1 a b)
  (list->set
   (filter (lambda (x) (set-member? b x))
           (set->list a))))
(equal? (f1 (set 0 1 2 3) (set 2 3 4 5)) (set 2 3)) ;; #t
(equal? (f1 (set 0 1 2) (set 3 4 5)) (set ))  ;; #t
(equal? (f1 (set 'a 'b 'c 'd) (set 'c 'e 'a 'f 'd)) (set 'a 'c 'd)) ;; #t
