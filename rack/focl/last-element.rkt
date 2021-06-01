;; https://www.4clojure.com/problem/19

;; 1
(define (f1 coll)
  (if (null? (cdr coll))
      (car coll)
      (f1 (cdr coll))))
(equal? (f1 '(1 2 3 4 5)) 5) ;; #t
(equal? (f1 '(1 2 3 4 5)) 5) ;; #t
(equal? (f1 '(5 4 3)) 3) ;; #t
(equal? (f1 '("b" "c" "d")) "d") ;; #t
