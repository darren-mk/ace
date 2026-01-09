(ns ace.focl.p032
  (:require
   [clojure.test :as t]))

;; https://www.4clojure.com/problem/32

(defn run [f]
  (and (= (f [1 2 3]) '(1 1 2 2 3 3))
       (= (f [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
       (= (f [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
       (= (f [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))))

(defn a [vct]
  (loop [l (into '() vct) r nil]
    (if (empty? l)
      r
      (recur
       (rest l)
       (conj r (first l) (first l))))))

(defn b [coll]
  (->> coll
       (mapcat #(take 2 (repeat %)))))

(defn c [coll]
  (reduce
   (fn [coll x] (conj coll x x))
   []
   coll))

(defn d [coll]
  (reduce (fn [acc x] (conj acc x x)) [] coll))

(defn e [coll]
  (apply concat (map (fn [x] [x x]) coll)))

(defn f
  ([l]
   (f l []))
  ([[x & xs] acc]
   (if (nil? x) acc
       (f xs (conj (conj acc x) x)))))

(defn g [l]
  (reduce (fn [acc x] (conj (conj acc x) x)) [] l))

(t/deftest all
  (t/are [fnc] (run fnc)
    a b c d e f g))


