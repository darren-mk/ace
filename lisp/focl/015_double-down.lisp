;; https://4clojure.oxal.org/#/problem/15

;; 1
(defun f1 (x)
  (* x 2))
(equal (f1 2) 4) ;; t
(equal (f1 3) 6) ;; t
(equal (f1 11) 22) ;; t
(equal (f1 7) 14) ;; t
