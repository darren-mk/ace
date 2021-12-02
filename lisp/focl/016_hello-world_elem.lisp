;; https://4clojure.oxal.org/#/problem/16

;; 1
(defun f1 (s)
  (concatenate 'string "Hello, " s "!"))
(equal (f1 "Dave") "Hello, Dave!") ;; T
(equal (f1 "Jenn") "Hello, Jenn!") ;; T
(equal (f1 "Rhea") "Hello, Rhea!") ;; T
