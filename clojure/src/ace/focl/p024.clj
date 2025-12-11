(ns ace.focl.p024
  (:require
   [clojure.test :as t]))

;; Write a function which returns the sum of a sequence of numbers.

(defn run [f]
  (and (= (f [1 2 3]) 6)
       (= (f (list 0 -2 5 5)) 8)
       (= (f #{4 2 1}) 7)
       (= (f '(0 0 -1)) -1)
       (= (f '(1 10 3)) 14)))

(defn a [coll]
  (loop [c coll
         s 0]
    (if (empty? c)
      s
      (recur
       (rest c) (+ s (first c))))))

(defn b [coll]
  (reduce
   (fn [result elem] (+ result elem))
   0
   coll))

(defn c [coll]
  (reduce
   (fn [s v] (+ s v))
   0
   coll))

(defn d [coll]
  (if (empty? coll)
    0
    (+ (first coll)
       (d (rest coll)))))

(defn e [coll]
  (reduce
   (fn [sum elem] (+ sum elem))
   0
   coll))

(defn f [coll]
  (reduce + 0 coll))

(defn g
  ([l]
   (g l 0))
  ([[x & xs] s]
   (if-not x s (g xs (+ s x)))))

(defn h [l]
  (reduce (fn [a x] (+ a x)) 0 l))

(defn i [l]
  (reduce + l))

(t/deftest all
  (t/are [f] (run f)
    a b c d e f g h i))
