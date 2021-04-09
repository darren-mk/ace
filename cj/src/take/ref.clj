; create(ref)
(def a (ref '(1 2 3)))
;; => #'user/a

; read(deref)
(deref a)
;; => (1 2 3)
@a
;; => (1 2 3)

; rewrite(ref-set)
; (ref-set a '(3 2 1)) err!
(dosync (ref-set a "abc"))
;; => "abc"

(deref a)
;; => "abc"
