(in-package :arrow-macros)

(-> 1
  (+ 2 3)
  #'1+
  1+
  (lambda (x) (+ x 1))
  (1+))
;; 10

(->> (list 1 2 3 4 5)
  (mapcar #'1+)
  (reduce #'+))
;; => 20
