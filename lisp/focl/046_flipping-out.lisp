;; https://4clojure.oxal.org/#/problem/46

;; 1
(defun f1 (f)
  (lambda (a b) (funcall f b a)))
(equal 3 (funcall (f1 #'nth) (list 1 2 3 4 5) 2)) ;; t
(equal t (funcall (f1 #'>) 7 8)) ;; t
;; (equal 4 (funcall (f1 #'rem) 8 2))
;; (equal (list 1 2 3) (funcall (f1 take) (list 1 2 3 4 5) 3))
