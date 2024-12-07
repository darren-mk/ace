;; https://4clojure.oxal.org/#/problem/21

;; 1
(defun f1 (l n)
  (if (= n 0)
      (car l)
      (f1 (cdr l) (- n 1))))
(equal (f1 '(4 5 6 7) 2) 6) ;; t
(equal (f1 (list :a :b :c) 0) :a) ;; t
(equal (f1 (list 1 2 3 4) 1) 2) ;; t
(equal (f1 (list (list 1 2) (list 3 4) (list 5 6)) 2) (list 5 6)) ;; t
