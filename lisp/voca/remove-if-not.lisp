(remove-if-not (lambda (x) (< x 3)) (list 1 2 3 4 5))
;; (1 2)

;; filter
(defun filter (f l)
  (remove-if-not f l))
(filter (lambda (x) (< x 3)) (list 1 2 3 4 5))
