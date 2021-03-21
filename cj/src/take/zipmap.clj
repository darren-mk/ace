(zipmap [:a :b :c] [1 2 3]) ;; => {:a 1, :b 2, :c 3}
(zipmap [:a :b :c] [1 2 3 4]) ;; => {:a 1, :b 2, :c 3}
(zipmap [:html :body] (repeat {:m 0 :p 0})) ;; => {:html {:m 0, :p 0}, :body {:m 0, :p 0}}
(zipmap [:a :b :c] (repeat 0)) ;; => {:a 0, :b 0, :c 0}
