(ns ace.voca.agent
  (:require
   [clojure.test :as t]))

(t/deftest counter-test
  (let [counter (agent 0)]
    (t/is (zero? (deref counter)))
    (send counter inc)
    (await counter)
    (t/is (= 1 (deref counter)))))
