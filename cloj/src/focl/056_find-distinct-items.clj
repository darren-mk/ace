;; https://4clojure.oxal.org/#/problem/56

(defn f1 [l]
  (let [f (fn [a x] (if (.contains a x) a (conj a x)))]
    (reduce f [] l)))
(= (f1 [1 2 1 3 1 2 4]) [1 2 3 4])
(= (f1 [:a :a :b :b :c :c]) [:a :b :c])
(= (f1 '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
(= (f1 (range 50)) (range 50))
