;; https://4clojure.oxal.org/#/problem/84


(defn f1 [coll]
  
  )
(let [divides #{[8 4] [9 3] [4 2] [27 9]}]
  (= (f1 divides) #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]}))
(let [more-legs #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}]
  (= (f1 more-legs)
     #{["cat" "man"] ["cat" "snake"] ["man" "snake"]
       ["spider" "cat"] ["spider" "man"] ["spider" "snake"]}))
(let [progeny
      #{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]}]
  (= (f1 progeny)
     #{["father" "son"] ["father" "grandson"]
       ["uncle" "cousin"] ["son" "grandson"]}))
