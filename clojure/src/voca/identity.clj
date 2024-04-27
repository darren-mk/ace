(comment
  (defn identity
  "Returns its argument."
    {:added "1.0"
     :static true}
    [x] x))

(identity [1 2 3])
;; => [1 2 3]

(identity 1)
;; => 1

(map identity {:a 1})
;; => ([:a 1])

(type (map identity {:a 1}))
;; => clojure.lang.LazySeq

(set (map identity {:a 1}))
;; => #{[:a 1]}

(vec (map identity {:a 1}))
;; => [[:a 1]]

(into [] (map identity {:a 1}))
;; => [[:a 1]]

(filter identity [1 2 nil 3 4 5])
;; => (1 2 3 4 5)
