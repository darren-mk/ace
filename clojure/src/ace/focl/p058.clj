(ns ace.focl.p058
  (:require
   [clojure.test :as t]))

;; Write a function which allows you to create function compositions.
;; The parameter list should take a variable number of functions,
;; and create a function applies them from right-to-left.
;; Special restriction: comp

(defn run [f]
  (and (= [3 2 1] ((f rest reverse) [1 2 3 4]))
       (= 5 ((f (partial + 3) second) [1 2 3 4]))
       (= true ((f zero? #(mod % 8) +) 3 5 7 9))
       (= "HELLO" ((f #(.toUpperCase %) #(apply str %) take) 5 "hello world"))))

(defn a [& fs]
  (fn [& vs]
    (reduce (fn [result f] (f result))
            (apply (last fs) vs)
            (reverse (butlast fs)))))

(t/deftest all
  (t/are [f] (run f)
    a))
