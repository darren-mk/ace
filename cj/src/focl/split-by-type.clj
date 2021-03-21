;; https://www.4clojure.com/problem/50

;; 1
(apply merge [{:a 1} {:b 2}]) ;; => {:a 1, :b 2}
(map (fn [x] {x (type x)}) [1 :a 2])
;; => ({1 java.lang.Long} {:a clojure.lang.Keyword} {2 java.lang.Long})
(apply merge '({1 java.lang.Long}
               {:a clojure.lang.Keyword}
               {2 java.lang.Long}))
;; => {1 java.lang.Long, :a clojure.lang.Keyword, 2 java.lang.Long}
(map (fn [x] {(val x) (key x)})
     {1 java.lang.Long
      :a clojure.lang.Keyword
      2 java.lang.Long})
;; => ({java.lang.Long 1} {clojure.lang.Keyword :a} {java.lang.Long 2})
(merge-with into
 '({java.lang.Long 1}
   {clojure.lang.Keyword :a}
   {java.lang.Long 2}))



(= (set (__ [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
(= (set (__ [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})
(= (set (__ [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})
