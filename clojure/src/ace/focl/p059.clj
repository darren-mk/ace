(ns ace.focl.p059
  (:require
   [clojure.test :as t]))

;; Juxtaposition
;; Take a set of functions and return a new function
;; that takes a variable number of arguments and
;; returns a sequence containing the result of applying
;; each function left-to-right to the argument list.

(defn run [f]
  (and (= [21 6 1]
          ((f + max min) 2 3 5 1 6 4))
       (= ["HELLO" 5]
          ((f #(.toUpperCase %) count) "hello"))
       (= [2 6 4]
          ((f :a :c :b) {:a 2, :b 4, :c 6
                         :d 8 :e 10}))))

(defn a [& fs]
  (fn [& xs]
    (mapv #(apply % xs) fs)))

(defn b [& fs]
  (fn [& vs]
    (mapv #(apply % vs) fs)))

(defn c [& fs]
  (fn [& xs]
    (map #(apply % xs) fs)))

(t/deftest all
  (t/are [f] (run f)
    a b c))
