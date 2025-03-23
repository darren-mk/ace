(def ^:dynamic *user*
  "Alice")
*user* ;; => "Alice"
(binding [*user* "Bob"]
  *user*) ;; => "Bob"
*user* ;; => "Alice"
