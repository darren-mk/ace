;; https://4clojure.oxal.org/#/problem/80

(defn f1 [n]
  (->> (range 1 n)
       (filter (fn [x] (zero? (rem n x))))
       (apply +)
       (= n)))
(= (f1 6) true) :=> true
(= (f1 7) false) :=> true
(= (f1 496) true) :=> true
(= (f1 500) false) :=> true
(= (f1 8128) true) :=> true
