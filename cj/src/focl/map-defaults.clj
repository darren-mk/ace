;; https://www.4clojure.com/problem/156

;; 1
(defn f1 [value vector]
  (into {}
        (for [item vector]
          {item value})))
(= (f1 0 [:a :b :c]) {:a 0 :b 0 :c 0}) ;; => true
(= (f1 "x" [1 2 3]) {1 "x" 2 "x" 3 "x"}) ;; => true
(= (f1 [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]}) ;; => true

;; 2
(defn f2 [v coll]
  (apply sorted-map 
   (mapcat (fn [x] [x v]) coll)))
(= (f2 0 [:a :b :c]) {:a 0 :b 0 :c 0}) ;; => true 
(= (f2 "x" [1 2 3]) {1 "x" 2 "x" 3 "x"}) ;; => true 
(= (f2 [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]}) ;; => true



