;; https://4clojure.oxal.org/#/problem/19
;; Problem 19
;; Write a function which returns the last element in a sequence.
;; (= (__ [1 2 3 4 5]) 5)
;; (= (__ '(5 4 3)) 3)
;; (= (__ ["b" "c" "d"]) "d")
;; Special Restrictions : last

;; 1
(defun f1 (a)
  (car (last a)))
(= (f1 '(1 2 3 4 5)) 5) ;; T
(= (f1 '(5 4 3)) 3) ;; T
(string= (f1 '("b" "c" "d")) "d") ;; T

;; 2
(defun f2 (a)
  (cond ((null a) nil)
	((equal 1 (length a)) (car a))
	(t (f2 (rest a)))))
(= (f2 '(1 2 3 4 5)) 5) ;; T
(= (f2 '(5 4 3)) 3) ;; T
(string= (f2 '("b" "c" "d")) "d") ;; T
