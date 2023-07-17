(interpose ", " ["me" "you" "us"])
;; => ("me" ", " "you" ", " "us") 

(interpose 0 [1 2 3])
;; => (1 0 2 0 3)

(defn interpose-a [x coll]
  (let [f (fn [a b] [a b])]
    (-> (map f coll (repeat x))
        flatten
        butlast)))

(interpose-a 0 [1 2 3])
;; => (1 0 2 0 3)
