(ns ace.voca.find
  (:require
   [clojure.test :as t]))

(defn find-a [m clue]
  (reduce (fn [_ [k v]]
            (when (= clue k)
              (reduced [k v])))
          nil m))

(t/deftest test-find-a
  (t/testing "Successful lookup"
    (t/is (= [:a 1] (find-a {:a 1 :b 2} :a))))
  (t/testing "Failed lookup returns nil"
    (t/is (nil? (find-a {:a 1 :b 2} :c))))
  (t/testing "Short-circuiting"
    (t/is (= [:found "yes"]
             (find-a {:found "yes" :ignore "no"} :found)))))
