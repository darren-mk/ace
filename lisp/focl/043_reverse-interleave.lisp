;; https://4clojure.oxal.org/#/problem/43




;; 1
(defun range (x y)
  (if (= x y)
      '()
      (cons x (range (+ x 1) y))))
(defun take-nth (n l &optional m)
  (let* ((m (or m 0))
	 (item (nth (* n m) l)))
    (if (null item)
	'()
	(cons item (take-nth n l (+ m 1))))))
(defun drop (n l)
  (if (= n 0)
      l
      (drop (- n 1) (cdr l))))
(defun take (n l)
  (if (= n 0)
      '()
      (cons (car l) (take (- n 1) (cdr l)))))
(defun drop-last (n l)
  (take (- (length l) n) l))
(defun f1 (l n)
  (let ((el (drop-last (rem (length l) n) l)))
    (loop :for i :in (range 0 n)
	  :collect (take-nth n (drop i el)))))
(equal (f1 (list 1 2 3 4 5 6) 2) '((1 3 5) (2 4 6))) ;; t
(equal (f1 (list 0 1 2 3 4 5 6 7 8 9) 3) '((0 3 6) (1 4 7) (2 5 8))) ;; t
(equal (f1 (list 0 1 2 3 4 5 6 7 8 9 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9))) ;; t
