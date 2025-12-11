;; clojure.core/keep
;; ([f] [f coll])
;; Returns a lazy sequence of the non-nil results of (f item). Note,
;; this means false return values will be included.  f must be free of
;; side-effects.  Returns a transducer when no collection is provided.

(keep even? (range 1 10))
;; => (false true false true false true false true false)

;; implementation 1
(defn keep-alt-1 [f coll]
  (for [item coll]
    (f item)))
;; => #'user/keep-alt-1
(keep-alt-1 even? (range 1 10))
;; => (false true false true false true false true false)

(defn keep-b [f coll]
  (map f coll))

(keep-b even? (range 1 10))
;; => (false true false true false true false true false)
