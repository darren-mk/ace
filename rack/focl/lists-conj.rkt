;; https://www.4clojure.com/problem/5
;; modified

;; 1
(define v1 '(1 2 3 4))
(equal? v1 (cons 1 '(2 3 4))) ;; #t
(equal? v1 (append '(1 2) '(3 4))) ;; #t
