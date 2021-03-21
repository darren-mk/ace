;; partial
(def add-hundred (partial + 100)) ;; => #'focl.core/add-hundred
(add-hundred 1) ;; => 101 
(add-hundred 1 2 3) ;; => 106 
(+ 100 1 2 3) ;; => 106
(def add-some-and (partial + 1 2 3))
(add-some-and 4 5) ;; => 15
