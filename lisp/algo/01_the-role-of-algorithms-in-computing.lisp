

(defstruct person
  name age)

(defstruct duet
  (members nil :type list))

(defvar p1 (make-person
	    :name "jack"
	    :age 32))

(defvar p2 (make-person
	    :name "jill"
	    :age 28))


(defvar d1 
  (make-duet
   :members (list p1 p2)))

(defvar d2
  (make-duet
   :members (list 1 2)))

(defvar d3
  (make-duet
   :members nil))

(defvar d4
  (make-duet
   :members "not possible"))





(defun small-number-array-p (thing)
  (and (arrayp thing)
       (<= (length thing) 10)
       (every #'numberp thing)
       (every (lambda (x) (< x 10)) thing)))

(small-number-array-p '#(1 3 2 4 5))


(deftype small-number-array (&optional type)
  `(and (array ,type 1)
        (satisfies small-number-array-p)))

(defstruct lucky
  name
  (nums nil :type small-number-array))


(defvar ml-1
  (make-lucky :name "trial"
	      :nums '#(1 2 3 4 5 6 7 8)))

(declaim (ftype
	  (function (fixnum) fixnum)
	  add))

(defun add (n)
  (+ n 1))

(let ((x 1))
  (if (< x 3)
      (add 7)
      (add "go")))
