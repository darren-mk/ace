(type-of 1)
;; BIT

(type-of 1.2)
;; SINGLE-FLOAT

(type-of "a")
;; (SIMPLE-ARRAY CHARACTER (1))

(type-of "ABC")
;; (SIMPLE-ARRAY CHARACTER (3))

(type-of (list 1 2 3))
;; CONS

(type-of (vector 1 2 3))
;; (SIMPLE-VECTOR 3)
