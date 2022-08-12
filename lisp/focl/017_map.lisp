;; https://4clojure.oxal.org/#/problem/17

;; 1
(equal (list 6 7 8) (mapcar #'(lambda (x) (+ x 5)) '(1 2 3))) ;; T

;; 2
(defun add-five (x) (+ x 5))
(equal '(6 7 8) (mapcar #'add-five '(1 2 3))) ;; T
