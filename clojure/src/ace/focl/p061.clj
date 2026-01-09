(ns ace.focl.p061
  (:require
   [clojure.test :as t]))

;; Write a function which takes a vector of keys and
;; a vector of values and constructs a map from them.

(defn run [f]
  (and (= (f [:a :b :c] [1 2 3])
          {:a 1, :b 2, :c 3})
       (= (f [1 2 3 4] ["one" "two" "three"])
          {1 "one", 2 "two", 3 "three"})
       (= (f [:foo :bar] ["foo" "bar" "baz"])
          {:foo "foo", :bar "bar"})))

(defn a [coll1 coll2]
  (let [shorter (min (count coll1) (count coll2))]
    (loop [i 0
           m {}]
      (if (<= shorter i)
        m
        (recur (inc i)
               (conj m {(get coll1 i) (get coll2 i)}))))))

(defn b [coll1 coll2]
  (apply hash-map (interleave coll1 coll2)))

(defn c [a b]
  (let [r (range (min (count a) (count b)))]
    (apply hash-map (mapcat (fn [n] [(get a n) (get b n)]) r))))

(defn d [a b]
  (into {} (map (fn [x y] {x y}) a b)))

(defn e [a b]
  (if (or (empty? a) (empty? b))
    {}
    (conj {(first a) (first b)}
          (e (rest a) (rest b)))))

(defn f [a b]
  (apply merge (map #(into {%1 %2}) a b)))

(t/deftest all
  (t/are [f] (run f)
    a b c d e f))
