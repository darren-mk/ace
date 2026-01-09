(ns ace.focle.p19
  (:require
   [clojure.test :as t]))

;; https://4clojure.oxal.org/#/problem/19

(defn run [f]
  (and (= (f [1 2 3 4 5]) 5)
       (= (f '(5 4 3)) 3)
       (= (f ["b" "c" "d"]) "d")))

(defn a [coll]
  (nth coll (- (count coll) 1)))

(defn b [coll]
  (-> coll
      reverse
      first))

(defn c [coll]
  (let [m (apply hash-map (interleave (iterate inc 0) coll))
        k (apply max (keys m))]
    (get m k)))

(defn d [coll]
  (-> coll
      reverse
      first))

(defn e [coll]
  (reduce
   (fn [a b] (if (nil? b) a b))
   coll))

(defn f [[x & xs]]
  (if xs (recur xs) x))

(defn g [l]
  (nth l (dec (count l))))

(defn h [[x & xs]]
  (if-not (seq xs) x (h xs)))

(t/deftest all
  (t/are [fnc] (run fnc)
    a b c d e f g h))
