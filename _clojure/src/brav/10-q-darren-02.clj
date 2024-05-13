;; create a function that takes an atom and an int
;; and increase the value of the atome by the given int

;; 1
(defn increase-atom-value-by-int
  [a i]
  (swap! a + i))
;; => #'user/increase-atom-value-by-int
(def my-atom (atom 0))
;; => #'user/my-atom
@my-atom
;; => 0
(increase-atom-value-by-int my-atom 2)
;; => 2
@my-atom
;; => 2
