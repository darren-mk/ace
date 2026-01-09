(ns ace.focl.p042
  (:require
   [clojure.test :as t]))

;; Write a function which calculates factorials.

(defn run [f]
  (and (= (f 1) 1)
       (= (f 3) 6)
       (= (f 5) 120)
       (= (f 8) 40320)))

(defn a [n]
  (loop [i n
         r 1]
    (if (<= i 1)
      r
      (recur
       (dec i)
       (* r i)))))

(defn b [n]
  (reduce * (take n (iterate dec n))))

(defn c [n]
  (->> n
       (iterate dec)
       (take n)
       (reduce *)))

(defn d [n]
  (reduce * (take n (iterate inc 1))))

(defn e [n]
  (reduce * (range 1 (inc n))))

(t/deftest all
  (t/are [f] (run f)
    a b c d e))
