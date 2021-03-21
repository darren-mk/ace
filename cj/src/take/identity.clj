(identity [1 2 3]) ;; => [1 2 3]
(identity 1) ;; => 1
(map identity {:a 1}) ;; => ([:a 1])
(type (map identity {:a 1})) ;; => clojure.lang.LazySeq
(set (map identity {:a 1})) ;; => #{[:a 1]}
(vec (map identity {:a 1})) ;; => [[:a 1]]
(into [] (map identity {:a 1})) ;; => [[:a 1]]
