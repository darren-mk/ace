(concatenate 'string "hello" "world")
;; "helloworld"

(concatenate 'list (list 1 2) (list 4 3 4 4))
;; (1 2 4 3 4 4)

(concatenate 'vector (list 1 2) (list 4 3 4 4))
;; #(1 2 4 3 4 4)

(concatenate 'vector (vector 1 2) (vector 4 3 4 4))
;; #(1 2 4 3 4 4)
