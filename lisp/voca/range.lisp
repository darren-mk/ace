(defun range (x y)
  (if (= x y)
      '()
      (cons x (range (+ x 1) y))))
(equal (range 1 4) '(1 2 3)) ;; t
(equal (range -2 2) '(-2 -1 0 1)) ;; t
(equal (range 5 8) '(5 6 7)) ;; t
