(when t 1)
;; 1

(when nil 1)
;; nil

(when t (+ 1 2))
;; 3

(defmacro when-r1 (p l)
  `(if ,p ,l nil))

(when-r1 t 1)
;; 1

(when-r1 nil 1)
;; nil

(when-r1 t (+ 1 2))
;; 3
