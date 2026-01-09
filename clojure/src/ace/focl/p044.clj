(ns ace.focl.p044
  (:require
   [clojure.test :as t]))

(defn run [f]
  (and (= (f 2 [1 2 3 4 5]) '(3 4 5 1 2))
       (= (f -2 [1 2 3 4 5]) '(4 5 1 2 3))
       (= (f 6 [1 2 3 4 5]) '(2 3 4 5 1))
       (= (f 1 '(:a :b :c)) '(:b :c :a))
       (= (f -4 '(:a :b :c)) '(:c :a :b))))

(defn a [n coll]
  (let [cnt (count coll)]
    (->> coll
         repeat
         (apply concat)
         (drop (if (pos? n) n (- cnt (rem (abs n) cnt))))
         (take cnt))))

(defn b [n l]
  (let [size (count l)]
    (cond (< n 0) (b (+ n size) l)
          (< size n) (b (- n size) l)
          :else (concat (drop n l) (take n l)))))

(t/deftest all
  (t/are [fnc] (run fnc)
    a b))
