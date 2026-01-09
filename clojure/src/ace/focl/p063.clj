(ns ace.focl.p063
  (:require
   [clojure.test :as t]))

;; Given a function f and a sequence s, write a function which returns a map.
;; The keys should be the values of f applied to each item in s.
;; The value at each key should be a vector of corresponding items in the order
;; they appear in s.

(defn run [f]
  (and (= (f #(> % 5) #{1 3 6 8})
          {false [1 3], true [6 8]})
       (= (f #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
          {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
       (= (f count [[1] [1 2] [3] [1 2 3] [2 3]])
          {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})))

(defn a [f coll]
  (let [step (fn [acc x]
               (let [k (f x)
                     vc (vec (conj (get acc k) x))]
                 (assoc acc k vc)))]
    (reduce step {} coll)))

(defn b [f coll]
  (-> (fn [acc x]
        (update acc (f x) (fnil conj []) x))
      (reduce {} coll)))

(t/deftest all
  (t/are [f] (run f)
    a b))
