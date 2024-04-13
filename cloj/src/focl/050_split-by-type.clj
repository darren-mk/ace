;; https://4clojure.oxal.org/#/problem/50

(defn f1 [l]
  (set
   (vals
    (group-by type l))))
(= (set (f1 [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}) :=> true
(= (set (f1 [:a "foo" "bar" :b])) #{[:a :b] ["foo" "bar"]}) :=> true
(= (set (f1 [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]}) :=> true

(defn f2 [l]
  (->> l (group-by type) vals set))
(= (set (f2 [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}) :=> true
(= (set (f2 [:a "foo" "bar" :b])) #{[:a :b] ["foo" "bar"]}) :=> true
(= (set (f2 [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]}) :=> true

(defn f3 [l]
  (let [f (fn [a x] (update a (type x) conj x))]
    (->> (reduce f {} l) vals (map (comp vec reverse)) set)))
(= (set (f3 [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}) :=> true
(= (set (f3 [:a "foo" "bar" :b])) #{[:a :b] ["foo" "bar"]}) :=> true
(= (set (f3 [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]}) :=> true
