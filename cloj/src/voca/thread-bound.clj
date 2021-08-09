(def ^:dynamic *address* "NJ")
;; => #'user/*address*

(thread-bound? #'*address*)
;; => false

(binding [*address* "FL"]
  (thread-bound? #'*address*))
;; => true
