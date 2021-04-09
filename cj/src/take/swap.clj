(def counter (atom 0))
;; => #'user/counter

@counter
;; => 0

(swap! counter inc)
;; => 1

@counter
;; => 1
