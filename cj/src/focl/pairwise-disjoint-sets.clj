;; https://www.4clojure.com/problem/153

;; trial 1
(clojure.set/intersection
 #{:a :b}
 #{:a :d}) ;; => #{:a}
(count #{:a}) ;; => 1
(map inc #{1 2 3}) ;; => (2 4 3)
(defn f1 [s]
  (as-> s v
    (apply clojure.set/intersection v)
    (count v)
    (if (= v 0) true false)))
(= (f1 #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})
   true) ;; => true
(= (f1 #{#{:a :b :c :d :e}
         #{:a :b :c :d}
         #{:a :b :c}
         #{:a :b}
         #{:a}})
   false) ;; => true
(= (f1 #{#{[1 2 3] [4 5]}
         #{[1 2] [3 4 5]}
         #{[1] [2] 3 4 5}
         #{1 2 [3 4] [5]}})
   true) ;; => true
(= (f1 #{#{'a 'b}
         #{'c 'd 'e}
         #{'f 'g 'h 'i}
         #{''a ''c ''f}})
   true) ;; => true
(= (f1 #{#{'(:x :y :z) '(:x :y) '(:z) '()}
         #{#{:x :y :z} #{:x :y} #{:z} #{}}
         #{'[:x :y :z] [:x :y] [:z] [] {}}})
   false) ;; => false
(= (f1 #{#{(= "true") false}
         #{:yes :no}
         #{(class 1) 0}
         #{(symbol "true") 'false}
         #{(keyword "yes") ::no}
         #{(class '1) (int \0)}})
   false) ;; => false
(= (f1 #{#{distinct?}
         #{#(-> %) #(-> %)}
         #{#(-> %) #(-> %) #(-> %)}
         #{#(-> %) #(-> %) #(-> %)}})
   true) ;; => true
(= (f1 #{#{(#(-> *)) + (quote mapcat) #_ nil}
         #{'+ '* mapcat (comment mapcat)}
         #{(do) set contains? nil?}
         #{, , , #_, , empty?}})
   false) ;; => false

;; 2
(defn f2 [st]
  (zero?
   (count 
    (apply clojure.set/intersection st))))
(= (f2 #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}}) true)
;; => true
(= (f2 #{#{:a :b :c :d :e}
         #{:a :b :c :d}
         #{:a :b :c}
         #{:a :b}
         #{:a}}) false) ;; => true
(= (f2 #{#{[1 2 3] [4 5]}
         #{[1 2] [3 4 5]}
         #{[1] [2] 3 4 5}
         #{1 2 [3 4] [5]}}) true) ;; => true
(= (f2 #{#{'a 'b}
         #{'c 'd 'e}
         #{'f 'g 'h 'i}
         #{''a ''c ''f}}) true) ;; => true
(= (f2 #{#{'(:x :y :z) '(:x :y) '(:z) '()}
         #{#{:x :y :z} #{:x :y} #{:z} #{}}
         #{'[:x :y :z] [:x :y] [:z] [] {}}}) false) ;; => false
(= (f2 #{#{(= "true") false}
         #{:yes :no}
         #{(class 1) 0}
         #{(symbol "true") 'false}
         #{(keyword "yes") ::no}
         #{(class '1) (int \0)}}) false) ;; => false
(= (f2 #{#{distinct?}
         #{#(-> %) #(-> %)}
         #{#(-> %) #(-> %) #(-> %)}
         #{#(-> %) #(-> %) #(-> %)}}) true) ;; => true
(= (f2 #{#{(#(-> *)) + (quote mapcat) #_ nil}
         #{'+ '* mapcat (comment mapcat)}
         #{(do) set contains? nil?}
         #{, , , #_, , empty?}}) false) ;; => false
