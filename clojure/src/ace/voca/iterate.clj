(ns ace.voca.iterate
  (:require
   [clojure.test :as t]))

(defn- run [fnc]
  (= '(10 12 14 16 18)
     (take 5 (fnc #(+ % 2) 10))))

(defn- a [f x]
  (lazy-seq (cons x (a f (f x)))))

(defn- b [f n]
  (lazy-seq (cons n (b f (f n)))))

(t/deftest all
  (t/are [fnc] (run fnc)
    a b))
