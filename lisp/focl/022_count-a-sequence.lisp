;; https://4clojure.oxal.org/#/problem/22

;; 1
(defun f1 (l)
  (if (null l)
      0
      (+ 1 (f1 (cdr l)))))

(equal (f1 '(1 2 3 3 1)) 5) ;; t
;; (equal (f1 "Hello World") 11)
(equal (f1 (list (list 1 2) (list 3 4) (list 5 6))) 3) ;; t
(equal (f1 '(13)) 1) ;; t
(equal (f1 '(:a :b :c)) 3) ;; t
