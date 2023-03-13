(defmacro add-one (x)
  `(+ 1 ,x))

(add-one 3)
;; 4

(macroexpand '(add-one (+ 3 3)))
;; (+ 1 (+ 3 3))
;; T

(defmacro sum-list (l)
  `(+ ,@l))

(sum-list (1 2 3))
;; 6

(macroexpand '(sum-list (1 2 3)))
;; (+ 1 2 3)
;; T

;; make setq-two
;; https://lispcookbook.github.io/cl-cookbook/macros.html
(defvar v1 0)
(defvar v2 0)
(defmacro setq-two (x y v)
  `(progn
     (setq ,x ,v)
     (setq ,y ,v)))
(setq-two v1 v2 7) ; sets both v1 v2 to 7
(macroexpand '(setq-two v1 v2 7)) ; (PROGN (SETQ V1 7) (SETQ V2 7)), T

;; make setq-either
;; https://lispcookbook.github.io/cl-cookbook/macros.html
(defmacro setq-either (x y direction)
  `(case ,direction
     (:forward (setq ,x ,y))
     (:backword (setq ,y ,x))
     (t (error "unknown direction: ~a" ,direction))))
(macroexpand '(setq-either a b :forward))
(defvar v3 5)
(defvar v4 7)
(setq-either v3 v4 :forward) ; both are 7
(defvar v5 9)
(defvar v6 11)
(setq-either v5 v6 :backword) ; both are 9
(setq-either v5 v6 :nothing) ; creates an error
