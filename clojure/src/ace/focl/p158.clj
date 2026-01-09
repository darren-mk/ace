(ns ace.focl.p158
  (:require
   [clojure.test :as t]))

;; Write a function that accepts a curried function of unknown
;; arity n. Return an equivalent function of n arguments.

(defn run [f]
  (and (= 10 ((f (fn [a] (fn [b] (fn [c] (fn [d] (+ a b c d)))))) 1 2 3 4))
       (= 24 ((f (fn [a] (fn [b] (fn [c] (fn [d] (* a b c d)))))) 1 2 3 4))
       (= 25 ((f (fn [a] (fn [b] (* a b)))) 5 5))))


