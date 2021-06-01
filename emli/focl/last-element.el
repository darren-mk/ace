;; https://www.4clojure.com/problem/19

;; 1
(defun f1 (l)
  (car (last l)))
(= (f1 '(1 2 3 4 5)) 5) ;; t
(= (f1 '(5 4 3)) 3) ;; t
(= (f1 '(?\b ?\c ?\d)) ?\d) ;; t 

;; 2
(defun f2 (l)
  (->> l
    last
    car))
(= (f2 '(1 2 3 4 5)) 5) ;; t
(= (f2 '(5 4 3)) 3) ;; t
(= (f2 '(?\b ?\c ?\d)) ?\d) ;; t 
