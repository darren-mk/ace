;; fn?
(fn? 5) ;; => false
(fn? inc) ;; => true
(fn? (fn [])) ;; => true
(fn? #(5)) ;; => true
