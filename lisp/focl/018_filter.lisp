;; https://4clojure.oxal.org/#/problem/18

;; 1
(equal (list 6 7) (remove-if-not (lambda (x) (> x 5)) '(3 4 5 6 7)))
