(ns ace.focl.p026
  (:require
   [clojure.test :as t]))

;; Write a function which returns the first X fibonacci numbers.

(defn run [f]
  (and (= (f 3) '(1 1 2))
       (= (f 6) '(1 1 2 3 5 8))
       (= (f 8) '(1 1 2 3 5 8 13 21))))

(defn a [n]
  (take n
        (map last 
             (iterate
              (fn [[x y]] [y (+ x y)])
              [0 1]))))

(defn b-fib [x]
  (if (<= x 2)
    1
    (+ (b-fib (- x 1))
       (b-fib (- x 2)))))

(defn b [n]
  (map b-fib (range 1 (inc n))))

(defn c [n]
  (nth
   (iterate
    (fn [coll]
      (conj coll
            (+ (first (reverse coll))
               (second (reverse coll)))))
    [1 1])
   (- n 2)))

(defn d-f [x]
  (case x
    1 1
    2 1
    (+ (d-f (dec x))
       (d-f (- x 2)))))

(def d-mf (memoize d-f))

(defn d
  ([n]
   (d n '()))
  ([n acc]
   (if (< n 1) acc
       (d (dec n) (cons (d-mf n) acc)))))

(defn e [n]
  (map #(d-mf (inc %)) (range n)))


(t/deftest all
  (t/are [f] (run f)
    a b c d e))
