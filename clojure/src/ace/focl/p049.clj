(ns ace.focl.p049
  (:require
   [clojure.test :as t]))

(defn run [f]
  (and (= (f 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
       (= (f 1 [:a :b :c :d]) [[:a] [:b :c :d]])
       (= (f 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])))

(defn a [n coll]
  [(take n coll)
   (drop n coll)])

(t/deftest all
  (t/are [fnc] (run fnc)
    a))
