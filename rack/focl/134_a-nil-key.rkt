;; https://4clojure.oxal.org/#/problem/134

;; 1
(define (f1 h k)
  (if (null? (hash-ref h k))
      #t
      #f))
(equal? #t (f1 (hash 'a null 'b 2) 'a)) ;; #t
(equal? #f (f1 (hash 'a null 'b 2) 'b)) ;; #t
(false? (f1 (hash 'a null 'b 2) 'c))
