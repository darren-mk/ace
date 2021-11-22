;; https://4clojure.oxal.org/#/problem/5

;; 1
(equal '(1 2 3 4) (cons 1 '(2 3 4))) ;; T
(equal '(1 2 3 4) (cons 1 (cons 2 '(3 4)))) ;; T 
