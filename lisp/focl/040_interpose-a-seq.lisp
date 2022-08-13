;; https://4clojure.oxal.org/#/problem/40

;; 1
(defun f1 (x l)
  (if (= 1 (length l))
      l
      (concatenate 'list
		   (list (car l) x)
		   (f1 x (cdr l)))))
(equal (f1 0 (list 1 2 3)) (list 1 0 2 0 3)) ;; t
(equal (f1 :z (list :a :b :c :d)) (list :a :z :b :z :c :z :d)) ;; t
