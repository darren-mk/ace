;; https://4clojure.oxal.org/#/problem/19
;; Problem 19
;; Write a function which returns the last element in a sequence.
;; (= (__ [1 2 3 4 5]) 5)
;; (= (__ '(5 4 3)) 3)
;; (= (__ ["b" "c" "d"]) "d")
;; Special Restrictions : last

(defun f1 (a)
  (car (last a)))
(= (f1 '(1 2 3 4 5)) 5) ;; T
(= (f1 '(5 4 3)) 3) ;; T
(string= (f1 '("b" "c" "d")) "d") ;; T
