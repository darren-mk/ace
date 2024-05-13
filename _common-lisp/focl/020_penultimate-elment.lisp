;; https://4clojure.oxal.org/#/problem/20

;; 1
(defun f1 (l)
  (if (<= (length l) 2)
      (car l)
      (f1 (cdr l))))
(equal (f1 (list 1 2 3 4 5)) 4) ;; t
(equal (f1 (list "a" "b" "c")) "b") ;; t
(equal (f1 (list (list 1 2) (list 3 4))) (list 1 2)) ;; t
