(ns ace.focl.p021
  (:require
   [clojure.test :as t]))

;; Write a function which returns the Nth element from a sequence.

(defn run [f]
  (and (= (f '(4 5 6 7) 2) 6)
       (= (f [:a :b :c] 0) :a)
       (= (f [1 2 3 4] 1) 2)
       (= (f '([1 2] [3 4] [5 6]) 2) [5 6])))

(defn a [coll index]
  (loop [c coll i 0]
    (if (>= i index)
      (first c)
      (recur (rest c) (inc i)))))

(defn b [coll index]
  (get
   (into
    {} (map-indexed hash-map coll))
   index))

(defn c [coll index]
  (as-> coll c
    (zipmap (iterate inc 0) c)
    (get c index)))

(defn d [coll index]
  (get (vec coll) index))

(defn e [coll index]
  (key
   (first
    (filter
     (fn [item] (= (val item) index))
     (zipmap coll (iterate inc 0))))))

(defn f [coll index]
  (->> coll
       (zipmap (iterate inc 0))
       (filter #(= (key %) index))
       first
       val))

(defn g [coll n]
  (-> (zipmap (range (inc n)) coll)
      (get n)))

(defn h [coll n]
  (get
   (zipmap (iterate inc 0) coll)
   n))

(defn i
  ([l n]
   (i l n 0))
  ([[x & xs] n idx]
   (if (= n idx)
     x
     (recur xs n (inc idx)))))

(defn j [[x & xs] n]
  (if (zero? n) x
      (j xs (dec n))))

(t/deftest all
  (t/are [f] (run f)
    a b c d e f g h i j))
