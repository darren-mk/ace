(defun take (n l)
  (if (= n 0)
      '()
      (cons (car l) (take (- n 1) (cdr l)))))

(defun drop-last (n l)
  (take (- (length l) n) l))

(drop-last 2 (list 1 2 3 4 5))
;; (1 2 3)
