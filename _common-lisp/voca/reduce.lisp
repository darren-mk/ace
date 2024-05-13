;; http://clhs.lisp.se/Body/f_reduce.htm

(reduce #'* '(1 2 3 4 5))
;; => 120

(reduce #'append '((1) (2))
	:initial-value '(i n i t))
;; => (I N I T 1 2)

(reduce #'append '((1) (2))
	:from-end t                  
	:initial-value '(i n i t))
;; => (1 2 I N I T) 

(reduce #'- '(1 2 3 4))
;; == (- (- (- 1 2) 3) 4) =>  -8

(reduce #'- '(1 2 3 4) :from-end t)    ;Alternating sum.
;; == (- 1 (- 2 (- 3 4))) =>  -2

(reduce #'+ '())
;; => 0

(reduce #'+ '(3))
;; => 3

(reduce #'+ '(foo))
;; => FOO

(reduce #'list '(1 2 3 4))
;; => (((1 2) 3) 4)

(reduce #'list '(1 2 3 4) :from-end t)
;; => (1 (2 (3 4)))

(reduce #'list '(1 2 3 4) :initial-value 'foo)
;; => ((((foo 1) 2) 3) 4)

(reduce #'list '(1 2 3 4)
	:from-end t
	:initial-value 'foo)
;; => (1 (2 (3 (4 foo))))
