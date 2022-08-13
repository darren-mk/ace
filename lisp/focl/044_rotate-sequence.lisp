;; https://4clojure.oxal.org/#/problem/44

;; 1
(defun range (x y)
  (if (= x y)
      '()
      (cons x (range (+ x 1) y))))
(defun take-1 (l start end i result)
  (let* ((ni (if (= i 0) start i)))
    (if (= ni end)
	result
	(take l start end (+ ni 1) (concatenate 'list result (list (nth ni l)))))))
(defun f1 (n l)
  (let* ((len (length l))
	 (pn (if (< n 0) (+ len n) n))
	 (nl (concatenate 'list l l l))
	 (ind (range 0 len))
	 (rng (mapcar (lambda (x) (+ x pn)) ind))
	 (start (car rng))
	 (end (+ 1 (car (last rng)))))
    (take-1 nl start end 0 '())))
(equal (f1 2 (list 1 2 3 4 5)) '(3 4 5 1 2)) ;; t
(equal (f1 -2 (list 1 2 3 4 5)) '(4 5 1 2 3)) ;; t
(equal (f1 6 (list 1 2 3 4 5)) '(2 3 4 5 1)) ;; t
(equal (f1 1 '(:a :b :c)) '(:b :c :a)) ;; t
(equal (f1 -4 '(:a :b :c)) '(:c :a :b)) ;; not working

;; 2
(defun take (n l)
  (if (= n 0)
      '()
      (cons (car l) (take (- n 1) (cdr l)))))
(defun drop (n l)
  (if (= n 0)
      l
      (drop (- n 1) (cdr l))))
(defun f2 (n l)
  (let ((m (mod n (length l))))
    (concatenate 'list
		 (drop m l)
		 (take m l))))
(equal (f2 2 (list 1 2 3 4 5)) '(3 4 5 1 2)) ;; t
(equal (f2 -2 (list 1 2 3 4 5)) '(4 5 1 2 3)) ;; t
(equal (f2 6 (list 1 2 3 4 5)) '(2 3 4 5 1)) ;; t
(equal (f2 1 '(:a :b :c)) '(:b :c :a)) ;; t
(equal (f2 -4 '(:a :b :c)) '(:c :a :b)) ;; t
