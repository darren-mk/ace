;; Returns a seq on the collection.
;; If the collection is empty, returns nil.
;; (seq nil) returns nil. seq also works on
;; Strings, native Java arrays (of reference types)
;; and any objects that implement Iterable.
;; Note that seqs cache values, thus seq
;; should not be used on any Iterable whose iterator repeatedly
;; returns the same mutable object.

(seq [1 2 3])
:=> '(1 2 3)

(seq #{1 2 3})
:=> '(1 3 2)

(seq '(1))
;;=> (1)

(seq [1 2])
;;=> (1 2)

(seq "abc")
;;=> (\a \b \c)

(seq nil)
;;=> nil

(seq '())
;;=> nil

(seq [])
;;=> nil

(seq "")
;;=> nil

(type (seq [1 2 3]))
:=> "clojure.lang.PersistentVector$ChunkedSeq"

(type (seq #{1 2 3}))
:=> "clojure.lang.APersistentMap$KeySeq"

(type (seq {1 2 3 4}))
:=> "clojure.lang.PersistentArrayMap$Seq"

(seq? [1 2 3])
:=> false

(seq? '(1 2 3))
:=> true

(list? '(1 2 3))
:=> true

(seq? #{1 2 3})
:=> false

(type (range 10))
:=> "clojure.lang.LongRange"

(list? (rest '(1 2 3)))
:=> true

(list? (rest [1 2 3]))
:=> false

(rest '(1 2 3))
:=> '(2 3)

(rest [1 2 3])
:=> '(2 3)

(type (rest '(1 2 3)))
:=> "clojure.lang.PersistentList"

(type (rest [1 2 3]))
:=> "clojure.lang.PersistentVector$ChunkedSeq"

(seq? (rest [1 2 3]))
:=> true
