;; https://4clojure.oxal.org/#/problem/91

(defn f1 [coll]
  
  )
(= true (f1 #{[:a :a]}))
(= true (f1 #{[:a :b]}))
(= false (f1 #{[1 2] [2 3] [3 1]
               [4 5] [5 6] [6 4]}))
(= true (f1 #{[1 2] [2 3] [3 1]
              [4 5] [5 6] [6 4] [3 4]}))
(= false (f1 #{[:a :b] [:b :c] [:c :d]
               [:x :y] [:d :a] [:b :e]}))
(= true (f1 #{[:a :b] [:b :c] [:c :d]
              [:x :y] [:d :a] [:b :e] [:x :a]}))
