;; clojure.core/peek
;; ([coll])
;; For a list or queue, same as first, for a vector, same as, but much
;; more efficient than, last. If the collection is empty, returns nil.

(peek (list 1 2 3))
;; => 1

(peek (vector 1 2 3))
;; => 3

(peek [1 2 3])
;; => 3

(last [1 2 3])
;; => 3
