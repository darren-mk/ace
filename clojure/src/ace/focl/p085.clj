(ns ace.focl.p085
  (:require
   [clojure.test :as t]))

;; Write a function which generates the power set of a given set.
;; The power set of a set x is the set of all subsets of x,
;; including the empty set and x itself.

(defn run [f]
  (and (= (f #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})
       (= (f #{}) #{#{}})
       (= (f #{1 2 3})
          #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})
       (= (count (f (into #{} (range 10)))) 1024)))

(defn a [c]
  (reduce
   (fn [acc elem]
     (into acc (map #(conj % elem) acc)))
   #{#{}}
   c))

(defn b [s]
  (if (empty? s)
    #{#{}}
    (let [head (first s)
          tail-p (b (rest s))]
      (into tail-p (map #(conj % head) tail-p)))))

(t/deftest all
  (t/are [f] (run f)
    a b))
