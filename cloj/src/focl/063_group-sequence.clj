;; https://4clojure.oxal.org/#/problem/63

(defn f1 [f coll]
  (let [f (fn [a x]
            (let [k (f x)
                  vc (vec (conj (get a k) x))]
              (assoc a (f x) vc)))]
    (reduce f {} coll)))

(= (f1 #(> % 5) #{1 3 6 8}) {false [1 3], true [6 8]})
:=> true
(= (f1 #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
:=> true
(= (f1 count [[1] [1 2] [3] [1 2 3] [2 3]])
   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})
:=> true
