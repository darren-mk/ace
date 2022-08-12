(defun into-pairs (l &optional nl)
  (if (null l)
      nl
      (into-pairs (cddr l)
		  (cons (cons (nth 0 l)
			      (nth 1 l))
			nl))))

(defun hash (&rest l)
  (let ((pairs (into-pairs l))
	(tbl (make-hash-table)))
    (dolist (pair pairs)
      (setf (gethash (car pair) tbl) (cdr pair)))
    tbl))

(hash 'a 1 'b 2)

(hash 'foo 100 'bar 200 'baz 300)
