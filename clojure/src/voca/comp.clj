((comp count filter) even? [1 2 3 4 5])
;; => 2

((comp inc dec inc *) 1 2 3)
;; => 7

((comp :street :address)
 {:name "abc"
  :address {:street "mochi"
            :planet "toto"}})
;; => "mochi"

;; find nodes that have no or empty child
(def nodes [{:name "a" :child ["b" "c"]}
            {:name "b"}
            {:name "c" :child []}])
;; => #'user/nodes
(filter (comp empty? :child) nodes)
;; => ({:name "b"} {:name "c", :child []})
