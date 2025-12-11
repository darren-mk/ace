(ns ace.focl.p023
  (:require
   [clojure.test :as t]))

;; Write a function which reverses a sequence.
;; Special restriction: reverse

(defn run [f]
  (and (= (f [1 2 3 4 5]) [5 4 3 2 1])
       (= (f (sorted-set 5 7 2 7)) '(7 5 2))
       (= (f [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]])))

(defn a [seq]
  (loop [o seq r '()]
    (if (empty? o)
      r
      (recur (rest o)
             (conj r (first o))))))

(defn b [coll]
  (as-> coll c
    (zipmap (iterate dec (count c)) c)
    (sort c)
    (vals c)))

(defn c [coll]
  (vals
   (sort
    (zipmap (iterate dec 0) coll))))

(defn d [coll]
  (reduce
   (fn [new-coll elem] (cons elem new-coll))
   '()
   coll))

(defn e
  ([col]
   (e col '()))
  ([[x & xs] reversed]
   (if x (recur xs (conj reversed x))
       reversed)))

(defn f
  ([l]
   (f l '()))
  ([[x & xs] r]
   (prn r)
   (if-not x r
           (f xs (conj r x)))))

(t/deftest all
  (t/are [f] (run f)
    a b c d e f))
