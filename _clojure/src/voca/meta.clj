(meta #'inc)
;; => {:added "1.2",
;;     :ns #namespace[clojure.core],
;;     :name inc,
;;     :file "clojure/core.clj",
;;     :column 1,
;;     :line 922,
;;     :arglists ([x]),
;;     :doc
;;     "Returns a number one greater than num. Does not auto-promote\n  longs, will throw on overflow. See also: inc'",
;;     :inline #function[clojure.core/inc--inliner--5536]}

(meta #'identity)
;; => {:added "1.0",
;;     :ns #namespace[clojure.core],
;;     :name identity,
;;     :file "clojure/core.clj",
;;     :static true,
;;     :column 1,
;;     :line 1451,
;;     :arglists ([x]),
;;     :doc "Returns its argument."}

(meta #'partition)
;; => {:added "1.0",
;;     :ns #namespace[clojure.core],
;;     :name partition,
;;     :file "clojure/core.clj",
;;     :static true,
;;     :column 1,
;;     :line 3184,
;;     :arglists ([n coll] [n step coll] [n step pad coll]),
;;     :doc
;;     "Returns a lazy sequence of lists of n items each, at offsets step\n  apart. If step is not supplied, defaults to n, i.e. the partitions\n  do not overlap. If a pad collection is supplied, use its elements as\n  necessary to complete last partition upto n items. In case there are\n  not enough padding elements, return a partition with less than n items."}
