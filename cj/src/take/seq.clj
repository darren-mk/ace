(seq [1 2 3])
;; => (1 2 3)

(seq #{1 2 3})
;; => (1 3 2)

(type (seq [1 2 3]))
;; => clojure.lang.PersistentVector$ChunkedSeq

(type (seq #{1 2 3}))
;; => clojure.lang.APersistentMap$KeySeq

(type (seq {1 2 3 4}))
;; => clojure.lang.PersistentArrayMap$Seq

(seq? [1 2 3])
;; => false

(seq? '(1 2 3))
;; => true

(list? '(1 2 3))
;; => true

(seq? #{1 2 3})
;; => false

(type (range 10))
;; => clojure.lang.LongRange
