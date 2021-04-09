;; https://www.4clojure.com/problem/19

;; 1
(defun f1 (coll)
  (car (reverse coll)))
(= (f1 '(1 2 3 4 5)) 5) ;; T
(= (f1 '(5 4 3)) 3) ;; T
(string= (f1 '("b" "c" "d")) "d") ;; T
