;; https://www.4clojure.com/problem/21

;; 1
(define (f1 l n)
  (if (zero? n)
      (car l)
      (f1 (cdr l) (- n 1))))
(equal? (f1 '(4 5 6 7) 2) 6) ;; #t
(equal? (f1 '(a b c) 0) 'a) ;; #T
(equal? (f1 '(1 2 3 4) 1) 2) ;; #t
(equal? (f1 '((1 2) (3 4) (5 6)) 2) '(5 6)) ;; #t
