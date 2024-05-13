;; https://4clojure.oxal.org/#/problem/34

;; 1
(defun f1 (x y)
  (if (= x y)
      '()
      (cons x (f1 (+ x 1) y))))
(equal (f1 1 4) '(1 2 3)) ;; t
(equal (f1 -2 2) '(-2 -1 0 1)) ;; t
(equal (f1 5 8) '(5 6 7)) ;; t
