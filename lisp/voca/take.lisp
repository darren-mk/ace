(defun take (n l)
  (if (= n 0)
      '()
      (cons (car l) (take (- n 1) (cdr l)))))

(take 3 (list 1 2 3 4 5))
;; (1 2 3)

(take 0 (list 1 2 3))
;; nil

(take 4 (list 1 2 3))
;; (1 2 3 nil)
