(ns ace.focl.p020
  (:require
   [clojure.test :as t]))

;; Write a function which returns the second to last element from a sequence.

(defn run [f]
  (and (= (f (list 1 2 3 4 5)) 4)
       (= (f ["a" "b" "c"]) "b")
       (= (f [[1 2] [3 4]]) [1 2])))

(defn a [coll]
  (let [index-second-to-last (- (count coll) 2)]
    (nth coll index-second-to-last)))

(defn b [coll]
  (-> coll reverse second))

(defn c [coll]
  (let [m (apply hash-map (interleave (iterate inc 0) coll))
        k (- (apply max (keys m)) 1)]
    (get m k)))

(defn d [coll]
  (-> coll
      reverse
      second))

(defn e [coll]
  (let [v (into [] coll)]
    (get v (-> v count dec dec))))

(defn f
  ([col]
   (f nil col))
  ([prev [x & xs]]
   (if xs (recur x xs) prev)))

(defn g [l]
  (nth l (- (count l) 2)))

(t/deftest all
  (t/are [f] (run f)
    a b c d e f g))
