;; https://www.4clojure.com/problem/61

;; 1
(defn f1 [coll1 coll2]
  (let [shorter (min (count coll1) (count coll2))]
    (loop [i 0
           m {}]
      (if (<= shorter i)
        m
        (recur (inc i)
               (conj m {(get coll1 i) (get coll2 i)}))))))
(= (f1 [:a :b :c] [1 2 3])
   {:a 1, :b 2, :c 3}) ;; => true
(= (f1 [1 2 3 4] ["one" "two" "three"])
   {1 "one", 2 "two", 3 "three"}) ;; => true 
(= (f1 [:foo :bar] ["foo" "bar" "baz"])
   {:foo "foo", :bar "bar"}) ;; => true

;; 2
(defn f2 [coll1 coll2]
  (apply hash-map (interleave coll1 coll2)))
(= (f2 [:a :b :c] [1 2 3])
   {:a 1, :b 2, :c 3}) ;; => true
(= (f2 [1 2 3 4] ["one" "two" "three"])
   {1 "one", 2 "two", 3 "three"}) ;; => true
(= (f2 [:foo :bar] ["foo" "bar" "baz"])
   {:foo "foo", :bar "bar"}) ;; => true


;; 3
(mapcat (fn [n] [(get [:a :b :c] n) (get [1 2 3] n)] ) (range 4))
;; => (:a 1 :b 2 :c 3)
(apply hash-map [:a 1 :b 2 :c 3]) ;; => {:c 3, :b 2, :a 1}
(defn f3 [a b]
  (let [r (range (min (count a) (count b)))]
    (apply hash-map (mapcat (fn [n] [(get a n) (get b n)]) r))))
(= (f3 [:a :b :c] [1 2 3])
   {:a 1, :b 2, :c 3}) ;; => true
(= (f3 [1 2 3 4] ["one" "two" "three"])
   {1 "one", 2 "two", 3 "three"}) ;; => true
(= (f3 [:foo :bar] ["foo" "bar" "baz"])
   {:foo "foo", :bar "bar"}) ;; => true
