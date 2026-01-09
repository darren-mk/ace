(ns ace.focl.p041
  (:require
   [clojure.test :as t]))

(defn run [f]
  (and (= (f [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
       (= (f [:a :b :c :d :e :f] 2) [:a :c :e])
       (= (f [1 2 3 4 5 6] 4) [1 2 3 5 6])))

(defn a [coll n]
  (mapcat
   identity
   (partition-all (dec n) n coll)))

(defn b [coll n]
  (let [tagged (zipmap (iterate inc 1) coll)
        target (take (count coll)
                     (filter #(not= 0 (mod % n)) (iterate inc 1)))]
    (vals (select-keys tagged target))))

(defn c [l n]
  (->> (zipmap (iterate inc 1) l)
       (into (sorted-map))
       (filter (fn [elem] (not= 0 (mod (key elem) n))))
       vals))

(defn d [l n]
  (let [rec (fn [[acc mark] x]
             (if (= mark n)
               [acc 1]
               [(conj acc x) (inc mark)]))]
    (first (reduce rec [[] 1] l))))

(t/deftest all
  (t/are [fnc] (run fnc)
    a b c d))
