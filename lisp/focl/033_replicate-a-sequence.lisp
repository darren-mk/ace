;; https://4clojure.oxal.org/#/problem/33

;; 1
(defun repeat (x n)
  (if (= 0 n)
      '()
      (cons x (ff x (- n 1)))))
(defun f1 (l n)
  (if (null l)
      '()
      (concatenate 'list
		   (repeat (car l) n)
		   (f1 (cdr l) n))))
(equal (f1 (list 1 2 3) 2) '(1 1 2 2 3 3)) ;; t
(equal (f1 (list :a :b) 4) '(:a :a :a :a :b :b :b :b)) ;; t
(equal (f1 (list 4 5 6) 1) '(4 5 6)) ;; t
(equal (f1 (list (list 1 2) (list 3 4)) 2)
       '((1 2) (1 2) (3 4) (3 4))) ;; t 
(equal (f1 (list 44 33) 2) '(44 44 33 33)) ;; t
