;; https://4clojure.oxal.org/#/problem/39

;; 1
(defun f1 (la lb)
  (if (or (null la) (null lb))
      '()
      (concatenate 'list
		   (list (car la) (car lb))
		   (f1 (cdr la) (cdr lb)))))
(equal (f1 (list 1 2 3) (list :a :b :c)) '(1 :a 2 :b 3 :c)) ;; t
(equal (f1 (list 1 2) (list 3 4 5 6)) '(1 3 2 4)) ;; t
(equal (f1 (list 1 2 3 4) (list 5)) (list 1 5)) ;; t
(equal (f1 (list 30 20) (list 25 15)) (list 30 25 20 15)) ;; t
