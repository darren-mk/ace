(ns ace.voca.async
  (:require
   [clojure.core.async :as a]
   [clojure.test :as t]))

(defn roundtrip [v]
  (let [c (a/chan 1)]
    (a/>!! c v)
    (a/<!! c)))

(t/deftest roundtrip-test
  (t/is (= 1 (roundtrip 1))))

(defn sum-two [a b]
  (let [c (a/chan 2)]
    (a/>!! c a)
    (a/>!! c b)
    (+ (a/<!! c) (a/<!! c))))

(t/deftest sum-two-test
  (t/is (= 5 (sum-two 2 3)))
  (t/is (= 9 (sum-two 10 -1))))

(defn goroundtrip [v]
  (let [c (a/chan)]
    (a/go (a/>! c v))
    (a/<!! c)))

(t/deftest goroundtrip-test
  (t/is (= 1 (goroundtrip 1))))

(defn two-producers [a b]
  (let [c (a/chan)]
    (a/go (a/>! c a))
    (a/go (a/>! c b))
    (-> #{}
        (conj (a/<!! c))
        (conj (a/<!! c)))))

(t/deftest two-producers-test
  (t/is (= #{1 2} (two-producers 1 2))))

