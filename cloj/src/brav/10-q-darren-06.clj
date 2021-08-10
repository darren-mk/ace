;; alter a var temporarily

(def address "NJ")
;; => #'user/address

address
;; => "NJ"

(with-redefs [address "CA"]
  address)
;; => "CA"

address
;; => "NJ"
