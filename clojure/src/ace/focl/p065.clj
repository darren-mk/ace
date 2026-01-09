(ns ace.focl.p065
  (:require
   [clojure.test :as t]))

(defn run [f1]
  (and (= :map (f1 {:a 1, :b 2}))
       (= :list (f1 (range (rand-int 20))))
       (= :vector (f1 [1 2 3 4 5 6]))
       (= :set (f1 #{10 (rand-int 5)}))
       (= [:map :set :vector :list] (map f1 [{} #{} [] ()]))))

(defn a [x]
  (case (-> x str first)
    \[ :vector
    \{ :map
    \# :set
    \( :list))

(t/deftest all
  (t/are [fnc] (run fnc)
    a))


