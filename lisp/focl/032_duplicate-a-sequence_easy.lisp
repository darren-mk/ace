;; https://4clojure.oxal.org/#/problem/32

;; 1
(defun ffff1 (l)
  (reduce (lambda (a b) (cons a b))
	  l
	  )
  )


(reduce #'append '((1) (2) (3))
	:initial-value '())


(equal (f1 '(1 2 3)) '(1 1 2 2 3 3))
(equal (f1 '(:a :a :b :b)) '(:a :a :a :a :b :b :b :b))
(equal (f1 '('(1 2) '(3 4))) '('(1 2) '(1 2) '(3 4) '(3 4)))
(equal (f1 '(44 33)) '(44 44 33 33))
