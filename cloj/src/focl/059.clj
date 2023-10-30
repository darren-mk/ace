;; https://4clojure.oxal.org/#/problem/59

(defn f1 [& fs]
  (fn [& xs]
    (mapv #(apply % xs) fs)))
(= [21 6 1] ((f1 + max min) 2 3 5 1 6 4)) ;; true
(= ["HELLO" 5] ((f1 #(.toUpperCase %) count) "hello")) ;; true
(= [2 6 4] ((f1 :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10})) ;; true
