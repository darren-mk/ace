(def foobar)
;; => #'user/foobar
(bound? #'foobar)
;; => false

(def boing 10)
;; => #'user/boing
(bound? #'boing)
;; => true

(defn plus3 [n] (+ 3 n))
;; => #'user/plus3
(bound? #'plus3)
;; => true

(def x nil)
;; => #'user/x
(bound? #'x)
;; => true
