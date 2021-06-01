;; https://www.4clojure.com/problem/22

(define (f1 l)
  (if (null? l)
      0
      (+ 1 (f1 (cdr l)))))
(equal? (f1 '(1 2 3 3 1)) 5) ;; #t
(equal? (f1 (string->list "Hello World")) 11) ;; #t
(equal? (f1 '((1 2) (3 4) (5 6))) 3) ;; #t
(equal? (f1 '(13)) 1) ;; #t
(equal? (f1 '(#:a #:b #:c)) 3) ;; #t
