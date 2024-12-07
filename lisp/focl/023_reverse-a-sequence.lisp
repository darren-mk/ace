;; https://4clojure.oxal.org/#/problem/23

;; 1
(defun f1 (l)
  (if (null l)
      '()
      (cons (car (last l)) (f1 (butlast l)))))
(equal (f1 (list 1 2 3 4 5)) (list 5 4 3 2 1)) ;; t
(equal (f1 (list (list 1 2) (list 3 4) (list 5 6)))
       (list (list 5 6) (list 3 4) (list 1 2))) ;; t

;; 2
(defun f2 (l)
  (reverse l))
(equal (f2 (list 1 2 3 4 5)) (list 5 4 3 2 1)) ;; t
(equal (f2 (list (list 1 2) (list 3 4) (list 5 6)))
       (list (list 5 6) (list 3 4) (list 1 2))) ;; t
