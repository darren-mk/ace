(ns ace.focl.p022
  (:require
   [clojure.test :as t]))

;; Write a function which returns the total number of elements in a sequence.

(defn run [f]
  (and (= (f '(1 2 3 3 1)) 5)
       (= (f "Hello World") 11)
       (= (f [[1 2] [3 4] [5 6]]) 3)
       (= (f '(13)) 1)
       (= (f '(:a :b :c)) 3)))

(defn a [coll]
  (loop [i 0
         coll coll]
    (if (empty? coll)
      i
      (recur (inc i)
             (rest coll)))))

(defn b [coll]
  (apply max
         (keys
          (zipmap (iterate inc 1) coll))))

(defn c [coll]
  (->> (zipmap (iterate inc 0) coll)
       keys
       (apply max)
       inc))

(defn d [coll]
  (reduce (fn [count elem]
            (if (nil? elem)
              count
              (inc count)))
          0 coll))

(defn e [[x & xs]]
  (if x (inc (e xs)) 0))

(defn f
  ([col]
   (f col 0))
  ([[x & xs] len]
   (if x (recur xs (inc len))
       len)))

(defn g
  ([l]
   (g l 0))
  ([[x & xs] n]
   (if-not x n
           (g xs (inc n)))))

(t/deftest all
  (t/are [f] (run f)
    a b c d e f g))
