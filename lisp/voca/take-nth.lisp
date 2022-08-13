(defun take-nth (n l &optional m)
  (let* ((m (or m 0))
	 (item (nth (* n m) l)))
    (if (null item)
	'()
	(cons item (take-nth n l (+ m 1))))))

(take-nth 2 (list 0 1 2 3 4 5 6 7 8 9))
;; (0 2 4 6 8)
