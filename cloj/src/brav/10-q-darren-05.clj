;; alter a var permanently

(def address "NJ")
;; => #'user/address

address
;; => "NJ"

(alter-var-root #'address (fn [_] "NV"))
;; => "NV"

address
;; => "NV"
