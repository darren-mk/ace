;; https://4clojure.oxal.org/#/problem/63

(defn f1
  ([f l]
   (f1 f l {}))
  ([f l m]
   (if (empty? l) m
       (let [v (first l)
             k (f v)
             existing (get m k)
             v' (if existing (conj existing v) [v])
             m' (assoc m k v')]
         (f1 f (rest l) m')))))
(= (f1 #(> % 5) #{1 3 6 8}) {false [1 3], true [6 8]}) ;; true
(= (f1 #(apply / %) [[1 2] [2 4] [4 6] [3 6]]) ;; true
   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
(= (f1 count [[1] [1 2] [3] [1 2 3] [2 3]])
   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]}) ;; true
