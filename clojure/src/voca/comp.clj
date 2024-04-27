(comment
  (defn comp
    "Takes a set of functions and returns a fn that is the composition
  of those fns.  The returned fn takes a variable number of args,
  applies the rightmost of fns to the args, the next
  fn (right-to-left) to the result, etc."
    {:added "1.0"
     :static true}
    ([] identity)
    ([f] f)
    ([f g] 
     (fn 
       ([] (f (g)))
       ([x] (f (g x)))
       ([x y] (f (g x y)))
       ([x y z] (f (g x y z)))
       ([x y z & args] (f (apply g x y z args)))))
    ([f g & fs]
     (reduce1 comp (list* f g fs)))))

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
