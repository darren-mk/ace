(defun interleave (la lb)
  (if (or (null la) (null lb))
      '()
      (concatenate 'list
		   (list (car la) (car lb))
		   (interleave (cdr la) (cdr lb)))))
(equal (interleave (list 1 2 3) (list :a :b :c)) '(1 :a 2 :b 3 :c)) ;; t
(equal (interleave (list 1 2) (list 3 4 5 6)) '(1 3 2 4)) ;; t
(equal (interleave (list 1 2 3 4) (list 5)) (list 1 5)) ;; t
(equal (interleave (list 30 20) (list 25 15)) (list 30 25 20 15)) ;; t
