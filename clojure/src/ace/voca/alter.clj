(def age (ref 10))
;; => #'user/age

@age
;; => 10

(dosync 
 (alter age inc))
;; => 11

@age
;; => 11
