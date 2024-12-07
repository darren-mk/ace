(if t 1 2)
;; 1

(if nil 1 2)
;; 2

(if "hi" 1 2)
;; 1

(if t (+ 1 2) (+ 3 4))
;; 3

(defmacro if-r1 (p a b)
  `(if ,p ,a ,b))

(if-r1 t 1 2)
;; 1

(if-r1 nil 1 2)
;; 2

(if-r1 t (+ 1 2) (+ 3 4))
;; 3
