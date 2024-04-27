;; https://4clojure.oxal.org/#/problem/55

(defn f1 [l]
  (let [f (fn [a x] (if (get a x)
                      (update a x inc)
                      (assoc a x 1)))]
    (reduce f {} l)))
(= (f1 [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})
(= (f1 [:b :a :b :a :b]) {:a 2, :b 3})
(= (f1 '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})
