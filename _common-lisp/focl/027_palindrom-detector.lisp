;; https://4clojure.oxal.org/#/problem/27

;; 1
;; reverse the sequence, and
;; compare with the original.
(defun f1 (seq)
  (equal seq (reverse seq)))
(equal NIL (f1 '(1 2 3 4 5))) ;;T
(equal T (f1 "racecar")) ;;T
(equal T (f1 '(:foo :bar :foo))) ;;T
(equal T (f1 '(1 1 3 3 1 1))) ;;T
(equal NIL (f1 '(:a :b :c))) ;;T

;; 2
(defun f2 (l)
  (cond ((null l) t)
	((<= (length l) 1) t)
	((not (equal (car l) (car (last l)))) nil)
	(t (f2 (cdr (butlast l))))))
(equal NIL (f2 '(1 2 3 4 5))) ;;T
(equal T (f2 (coerce "racecar" 'list))) ;;T
(equal T (f2 '(:foo :bar :foo))) ;;T
(equal T (f2 '(1 1 3 3 1 1))) ;;T
(equal NIL (f2 '(:a :b :c))) ;;T
