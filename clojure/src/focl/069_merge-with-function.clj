;; https://4clojure.oxal.org/#/problem/69

(defn f1 [f & ms]
  (let [ks (->> ms (map keys) flatten set)
        f (fn [a k] (assoc a k
                           (->> ms
                                (map #(get % k))
                                (remove nil?)
                                (apply f))))]
    (reduce f {} ks)))
(= (f1 * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
   {:a 4, :b 6, :c 20}) :=> true
(= (f1 - {1 10, 2 20} {1 3, 2 10, 3 15})
   {1 7, 2 10, 3 15}) :=> false
(= (f1 concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
   {:a [3 4 5], :b [6 7], :c [8 9]}) :=> true
