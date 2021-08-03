;; create a function that takes an atom
;; and increments the value by 1

;; 1
(defn increment-atom-value
  [a]
  (swap! a inc))
;; => #'user/increment-atom-value
(def my-atom (atom 0))
;; => #'user/my-atom
@my-atom
;; => 0
(increment-atom-value my-atom)
;; => 1
@my-atom
;; => 1
