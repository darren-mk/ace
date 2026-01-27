(ns ace.voca.join
  (:require
   [clojure.string :as cstr]
   [clojure.test :as t]))

(t/deftest join-without-filling-test
  (t/is (= "abc" (cstr/join ["a" "b" "c"])
           (clojure.string/join [\a \b \c]))))

(t/deftest join-with-filling-test
  (t/is (= "a b c" (cstr/join #" " [\a \b \c])))
  (t/is (= "a, b, c" (cstr/join #", " [\a \b \c]))))
