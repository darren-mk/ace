;; https://4clojure.oxal.org/#/problem/48

;; 1
(equal (list 6) (some (lambda (x) (member x (list 2 7 6))) (list 5 6 7 8)))
(= 6 (some (lambda (x) (when (evenp x) x)) (list 5 6 7 8)))
