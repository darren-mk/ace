;; https://www.4clojure.com/problem/24

(require racket/set)

;; 1
(define (f1 l)
  (if (null? l)
      0
      (+ (car l) (f1 (cdr l)))))
(equal? (f1 (list 1 2 3)) 6) ;; #t
(equal? (f1 (list 0 -2 5 5)) 8) ;; #t
(equal? (f1 (set->list (set 4 2 1))) 7) ;; #t
(equal? (f1 '(0 0 -1)) -1) ;; #t
(equal? (f1 '(1 10 3)) 14) ;; #t
