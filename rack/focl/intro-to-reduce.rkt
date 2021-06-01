;; https://www.4clojure.com/problem/64

;; 1
(define f1 +)
(equal? 15 (foldl f1 0 '(1 2 3 4 5))) ;; #t
(equal? 0 (foldl f1 0 '())) ;; #t
(equal? 6 (foldl f1 1 '(2 3))) ;; #t


