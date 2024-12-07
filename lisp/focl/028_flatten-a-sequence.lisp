;; https://4clojure.oxal.org/#/problem/28

(defun f1 (x)
  (cond ((atom x) (list x))
        ((= 1 (length x)) (f1 (car x)))
        (t (concatenate 'list (f1 (car x)) (f1 (cdr x))))))
(equal (f1 '((1 2) 3 (4 (5 6)))) '(1 2 3 4 5 6)) ;; t
(equal (f1 '("a" ("b") "c")) '("a" "b" "c")) ;; t
(equal (f1 '((((:a))))) '(:a)) ;; t
