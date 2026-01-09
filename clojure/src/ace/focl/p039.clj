(ns ace.focl.p039
  (:require
   [clojure.test :as t]))

;; https://www.4clojure.com/problem/39

(defn- run [f]
  (and
   (= (f [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
   (= (f [1 2] [3 4 5 6]) '(1 3 2 4))
   (= (f [1 2 3 4] [5]) [1 5])
   (= (f [30 20] [25 15]) [30 25 20 15])))

(defn a [a-coll b-coll]
  (let [shorter (min (count a-coll)
                     (count b-coll))]
    (loop [i 0
           l []]
      (if (>= i shorter)
        l      
        (recur (inc i)
               (conj l
                     (nth a-coll i)
                     (nth b-coll i)))))))

(defn b [a b]
  (mapcat (fn [x y] [x y]) a b))

(defn c
  ([a b]
   (c a b []))
  ([[x & xs] [y & ys] acc]
   (if (or (nil? x) (nil? y)) acc
       (c xs ys (concat acc [x y])))))

(t/deftest all
  (t/are [fnc] (run fnc)
    a b c))
