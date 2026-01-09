(ns ace.voca.atom
  (:require
   [clojure.test :as t]))

(t/deftest counter-test
  (let [counter (atom 0)]
    (t/is (zero? (deref counter)))
    (swap! counter inc)
    (t/is (= 1 (deref counter)))))
