;; https://4clojure.oxal.org/#/problem/32

;; 1
(defun f1 (l)
  (if (null l)
      '()
      (concatenate 'list
		   (list (car l) (car l))
		   (f1 (rest l)))))
(equal (f1 '(1 2 3)) '(1 1 2 2 3 3)) ;; T
(equal (f1 '(:a :a :b :b)) '(:a :a :a :a :b :b :b :b)) ;; T
(equal (f1 '('(1 2) '(3 4))) '('(1 2) '(1 2) '(3 4) '(3 4))) ;; T
(equal (f1 '(44 33)) '(44 44 33 33)) ;; T
