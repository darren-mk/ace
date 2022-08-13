;; https://4clojure.oxal.org/#/problem/28

(defun f1 (l)
  (if (listp l)
      (mapcar #'f1 l)
      l)) ;; ??????
;; (equal (f1 '((1 2) 3 (4 (5 6)))) '(1 2 3 4 5 6))
;; (equal (f1 '("a" ("b") "c")) '("a" "b" "c"))
;; (equal (f1 '((((:a))))) '(:a))
