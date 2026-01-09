(ns ace.voca.exinfo
  (:require
   [clojure.test :as t]))

(def msg "hey")
(def data {:a 1 :b "r"})
(def exc (ex-info msg data))

(t/deftest basics-test
  (t/are [a b] (= a b)
    clojure.lang.ExceptionInfo (type exc)
    msg (ex-message exc)
    data (ex-data exc)
    msg (.getMessage exc)
    data (.getData exc)))

(t/deftest throw-test
  (try
    (throw exc)
    (catch clojure.lang.ExceptionInfo x
      (let [x' (ex-data x)]
        (t/is (= data x'))))))
