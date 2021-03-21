;; some
;; true if any value meets predicate
(some even? [1 2 3 4 5 6]) ;; => true
(some #(when (even? %) %) [1 2 3 4 5]) ;; => 2
(some neg? [-1 2 5]) ;; => true
