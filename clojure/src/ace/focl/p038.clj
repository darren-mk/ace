(ns ace.focl.p038
  (:require
   [clojure.test :as t]))

(defn- run [f]
  (and (= (f 1 8 3 4) 8)
       (= (f 30 20) 30)
       (= (f 45 67 11) 67)))

(defn a [& nums]
  (loop [max 0 coll nums]
    (if (empty? coll)
      max
      (recur (if (> (first coll) max) (first coll) max)
             (rest coll)))))

(defn b [& nums]
  (reduce
   (fn [v n] (if (< v n) n v))
   nums))

(defn c [& ns]
  (reduce (fn [max x] (if (< max x) x max)) ns))

(defn d [& nums]
  (reduce (fn [acc x] (if (< acc x) x acc))
          (first nums) nums))

(defn e [x & xs]
   (if (empty? xs) x
       (max x (apply e xs))))

(t/deftest all
  (t/are [fnc] (run fnc)
    a b c d e))
