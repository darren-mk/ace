(ns ace.focl.p055
  (:require
   [clojure.test :as t]))

(defn run [f]
  (and (= (f [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})
       (= (f [:b :a :b :a :b]) {:a 2, :b 3})
       (= (f '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})))

(defn a
  ([l]
   (a l {}))
  ([[x & xs] memo]
   (if (nil? x) memo
       (a xs
          (update memo x (fnil inc 0))))))

(t/deftest all
  (t/are [fnc] (run fnc)
    a))
