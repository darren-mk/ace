;; https://4clojure.oxal.org/#/problem/44

#lang racket

;; 1
(define (f1 n l)
  (let* [(pnt (remainder n (length l)))
         (rn (if (negative? pnt) (+ pnt (length l)) pnt))]
    (append
     (drop l rn)
     (take l rn))))
(equal? (f1 2 '(1 2 3 4 5)) '(3 4 5 1 2)) ;; #t
(equal? (f1 -2 '(1 2 3 4 5)) '(4 5 1 2 3)) ;; #t
(equal? (f1 6 '(1 2 3 4 5)) '(2 3 4 5 1)) ;; #t
(equal? (f1 1 '(:a :b :c)) '(:b :c :a)) ;; #t
(equal? (f1 -4 '(:a :b :c)) '(:c :a :b)) ;; #t
