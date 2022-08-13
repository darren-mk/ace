(defun drop (n l)
  (if (= n 0)
      l
      (drop (- n 1) (cdr l))))

(drop 2 (list 1 2 3 4 5))
;; (3 4 5)
