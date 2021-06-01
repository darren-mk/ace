; create(ref)
(def a (ref '(1 2 3)))
;; => #'user/a

; read(deref)
(deref a)
;; => (1 2 3)
@a
;; => (1 2 3)

;; rewrite(ref-set)
;; (ref-set a '(3 2 1)) err!
;; Because refs are mutable, you must protect their updates.
;; In many languages, you would use a lock for this purpose. In Clojure,
;; you can use a transaction. Transactions are wrapped in a dosync
(dosync (ref-set a "abc"))
;; => "abc"

(deref a)
;; => "abc"
