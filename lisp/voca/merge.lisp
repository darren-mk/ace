(merge 'list (list 1 2) (list 3 4) #'<)
;; (1 2 3 4)

(merge 'list (list 1 2) (list 3 4) #'>)
;; (3 4 1 2)

(merge 'list (list 1 4) (list 2 3) #'<)
;; (1 2 3 4)

(merge 'list (list 1 4) (list 2 3) #'>)
;; (2 3 1 4)

(merge 'list (list 1 4 2) (list 9 2 3) #'=)
;; (1 4 2 9 2 3)

(merge 'vector (list 1 2) (list 3 4) #'<)
;; #(1 2 3 4)

(merge 'vector (list 1 2) (list 3 4) #'>)
;; (3 4 1 2)

(merge 'list '(1 2 6) '(3 4 5) #'<)
;; (1 2 3 4 5 6)

(merge 'vector #(1 2 6) #(3 4 5) #'<)
;; #(1 2 3 4 5 6)
