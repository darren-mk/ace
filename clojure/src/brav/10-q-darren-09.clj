;; what is var and how it is works?

+
;; => #function[clojure.core/+]
(var +)
;; => #'clojure.core/+
#'+
;; => #'clojure.core/+
(= (var +) #'+)
;; => true
(deref (var +))
;; => #function[clojure.core/+]
(= + (deref (var +)))
;; => true
(meta +)
;; => nil
(meta (var +))
;; => {:added "1.2",
;;     :ns #namespace[clojure.core],
;;     :name +,
;;     :file "clojure/core.clj",
;;     :inline-arities #function[clojure.core/>1?],
;;     :column 1,
;;     :line 984,
;;     :arglists ([] [x] [x y] [x y & more]),
;;     :doc
;;     "Returns the sum of nums. (+) returns 0. Does not auto-promote\n  longs, will throw on overflow. See also: +'",
;;     :inline #function[clojure.core/nary-inline/fn--5541]}

;; https://clojure.org/reference/vars
;; Clojure is a practical language that recognizes the occasional need
;; to maintain a persistent reference to a changing value and
;; provides 4 distinct mechanisms for doing so in a controlled manner
;; - Vars, Refs, Agents and Atoms.
;; Vars provide a mechanism to refer to a mutable storage location
;; that can be dynamically rebound (to a new storage location) on a per-thread basis.
;; Every Var can (but needn’t) have a root binding,
;; which is a binding that is shared by all threads that do not have a per-thread binding.
;; Thus, the value of a Var is the value of its per-thread binding, or,
;; if it is not bound in the thread requesting the value, the value of the root binding, if any.
