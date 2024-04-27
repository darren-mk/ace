(rest '(1 2 3))
;; => (2 3)

(type (rest '(1 2 3)))
;; => clojure.lang.PersistentList

(rest [1 2 3])
;; => (2 3)

(type (rest [1 2 3]))
;; => clojure.lang.PersistentVector$ChunkedSeq

(rest #{1 2 3})
;; => (3 2)

(type (rest #{1 2 3}))
;; => clojure.lang.APersistentMap$KeySeq
