;; https://www.4clojure.com/problem/20

;; 1
(define (f1 coll)
  (if (equal? (length coll) 2)
      (car coll)
      (f1 (cdr coll))))
(equal? (f1 (list 1 2 3 4 5)) 4) ;; #t
(equal? (f1 '("a" "b" "c")) "b") ;; #t
(equal? (f1 '((1 2) (3 4))) '(1 2)) ;; #t
