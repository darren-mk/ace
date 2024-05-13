(defmacro defun-case (name &rest cases)
  (let ((args (gensym)))
    `(defun ,name (&rest ,args)
       (cond ,@(loop :for i :in cases
		     :collect `((= ,(length (car i)) (length ,args))
				(let ,(loop :for j :in (car i)
					    :for k :from 0 :to (length (car i))
					    :collect `(,j (nth ,k ,args)))
				  ,(cadr i))))))))

(defun-case
    derpi
    ((a) a)
  ((a b) (cons a b)))

(derpi 1)
;; 1

(derpi 1 2)
;; (1. 2)
