(ql:quickload :alexandria)

(defun mult-span-without-declaim (x)
  (apply #'* (alexandria:iota 10 :start 2 :step x)))

(time (mult-span-without-declaim 5))

(declaim (ftype (function (integer) integer) mult-span-with-declaim))

(defun mult-span-with-declaim (x)
  (apply #'* (alexandria:iota 10 :start 2 :step x)))

(time (mult-span-with-declaim 5))

;; macro for simplification

(defmacro :-> (fname args returned)
  `(declaim (ftype (function ,args ,returned) ,fname)))

(:-> add-two-nums (integer integer) integer)

(macroexpand '(:-> add-two-nums (integer integer) integer))

(defun add-two-nums (x y)
  (+ x y))

(add-two-nums 1 2)

(defun tluck (x)
  (if (< x 3)
      (print "one")
      ;; (add-two-nums 1.3 2.4) ; error
      (print "two")))
