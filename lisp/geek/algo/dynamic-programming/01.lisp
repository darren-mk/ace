




(defun fibonacci-a (x)
  (if (<= x 1)
      x
      (+ (fibonacci-a (- x 1))
	 (fibonacci-a (- x 2)))))

(time (fibonacci-a 30))

(defun fibonacci-b (x &optional lookup)
  (if lookup
      (+ x lookup)
      x)

  )

(fibonacci-b 3 10)



