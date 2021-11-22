(coerce '(1 2 3) 'vector)
;; #(1 2 3)

(coerce #(1 2 3) 'list)
;; '(1 2 3)

(coerce "a" 'character)
;; #\a

(coerce 0 'short-float)
;; 0.0

(coerce 3.5L0 'float)
;; => 3.5d0 

(coerce 7/2 'float)
;; 3.5

(coerce 4.5s0 'complex)
;; #C(4.5 0.0) 

(coerce 7/2 'complex)
;; 7/2 (3.5) 

(coerce #C(7/2 0) '(complex double-float))
;; #C(3.5d0 0.0d0)

(coerce x 't)
;; error
