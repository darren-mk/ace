;; https://www.4clojure.com/problem/146

;; 1
(defn f1 [m]
  (let [v1 (key (first m))
        m1 (val (first m))
        v2 (key (second m))
        m2 (key (second m))]
    (apply merge
           (concat 
            (for [item m1]
              {[v1 (key item)] (val item)})
            (for [item m2]
              {[v2 (key item)] (val item)}))
           
           
           
           ))
  
  

  )

(f1 :a {:p 1 :q 2}) ;; => ({[:a :p] 1} {[:a :q] 2})
(apply merge '({[:a :p] 1} {[:a :q] 2}))




(= (f1 {:a {:p 1, :q 2}
         :b {:m 3, :n 4}})
   '{[a p] 1, [a q] 2
     [b m] 3, [b n] 4})
(= (__ '{[1] {a b
              c d}
         [2] {q r
              s t
              u v
              w x}})
   '{[[1] a] b, [[1] c] d,
     [[2] q] r, [[2] s] t,
     [[2] u] v, [[2] w] x})
(= (__ '{m {1 [a b c]
            3 nil}})
   '{[m 1] [a b c], [m 3] nil})
