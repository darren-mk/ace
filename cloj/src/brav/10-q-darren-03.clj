;; create a dynamic var for your address
;; and change it temporarily to print

(def ^:dynamic *address* "NJ")
;; => #'user/*address*

(binding [*address* "NY"]
  (println *address*))
;; => nil
;; NY
