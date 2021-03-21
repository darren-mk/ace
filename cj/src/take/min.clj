(min 1 2 3) ;; => 1
(min [1 2 3]) ;; => [1 2 3] ;; not desired this way
(apply min [1 2 3]) ;; => 1
