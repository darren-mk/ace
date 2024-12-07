;; https://4clojure.oxal.org/#/problem/68

(def v1 [7 6 5 4 3])
(= v1
 (loop [x 5
        result []]
   (if (> x 0)
     (recur (dec x) (conj result (+ 2 x)))
     result)))
