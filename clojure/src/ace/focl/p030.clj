(ns ace.focl.p030
  (:require
   [clojure.test :as t]))

;; Write a function which removes consecutive duplicates from a sequence.

(defn run [f]
  (and
   (= (apply str (f "Leeeeeerrroyyy")) "Leroy")
   (= (f [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
   (= (f [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))))

(defn a [vct]
  (loop [r []
         l vct]  
    (if (empty? l)
      r
      (recur
       (if (= (last r) (first l))
         r
         (conj r (first l)))
       (rest l)))))

(defn b [s]
  (->> s
       (partition-by identity)
       (map first)))

(defn c [coll]
  (reduce
   (fn [cl x] (if (= (last cl) x) cl (conj cl x)))
   []
   coll))

(defn d [coll]
  (reduce
   (fn [x elem]
     (if (= (last x) elem)
       x
       (conj x elem)))
   []
   coll))

(defn e [coll]
  (loop [collected []
         coll coll]
    (if (empty? coll)
      collected
      (if (= (first coll) (last collected))
        (recur collected (rest coll))
        (recur (conj collected (first coll)) (rest coll))))))

(defn f [coll]
  (reduce (fn [acc x] (if (= (last acc) x)
                        acc
                        (conj acc x)))
          []
          coll))

(defn g [l]
  (reduce (fn [acc x]
            (if (= x (last acc))
              acc (conj acc x)))
          [] l))

(t/deftest all
  (t/are [fnc] (run fnc)
    a b c d e f g))
