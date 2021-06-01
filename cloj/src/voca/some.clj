(meta #'some)
;; => {:added "1.0",
;;     :ns #namespace[clojure.core],
;;     :name some,
;;     :file "clojure/core.clj",
;;     :static true,
;;     :column 1,
;;     :line 2692,
;;     :arglists ([pred coll]),
;;     :doc
;;     "Returns the first logical true value of (pred x) for any x in coll,\n  else nil.  One common idiom is to use a set as pred, for example\n  this will return :fred if :fred is in the sequence, otherwise nil:\n  (some #{:fred} coll)"}

(some even? [1 2 3 4 5 6])
;; => true

(some #(when (even? %) %) [1 2 3 4 5])
;; => 2

(some neg? [-1 2 5])
;; => true
