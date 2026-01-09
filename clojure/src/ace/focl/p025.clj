(ns ace.focl.p025
  (:require
   [clojure.test :as t]))

;; Write a function which returns only the odd numbers from a sequence.

(defn run [f]
  (and (= (f #{1 2 3 4 5}) '(1 3 5))
       (= (f [4 2 1 6]) '(1))
       (= (f [2 2 4 6]) '())
       (= (f [1 1 1 3]) '(1 1 1 3))))

(defn a [coll]
  (filter (fn [x] (= (rem x 2) 1)) coll))

(defn b [coll]
  (filter odd? coll))

(defn c [coll]
  (loop [r []
         coll coll]
    (if (empty? coll)
      r
      (recur (if (odd? (first coll))
               (conj r (first coll))
               r)
             (rest coll)))))

(defn d [coll]
  (reduce
   (fn [odd-list elem]
     (if (odd? elem)
       (conj odd-list elem)
       odd-list))
   []
   coll))

(defn e [coll]
  (reduce
   (fn [a y] (if (odd? y) (conj a y) a))
   []
   coll))

(defn f
  ([coll]
   (f coll []))
  ([[x & xs] acc]
   (if x (recur xs
                (if (odd? x) (conj acc x)
                    acc))
       acc)))

(defn g [l]
  (let [rec (fn [a x] (if (odd? x) (conj a x) a))]
    (reduce rec [] l)))

(defn h
  ([l]
   (h l []))
  ([[x & xs] a]
   (if-not x a
           (let [a' (if (odd? x) (conj a x) a)]
             (h xs a')))))

(t/deftest all
  (t/are [fnc] (run fnc)
    a b c d e f g h))
