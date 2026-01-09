(ns ace.voca.ref
  (:require
   [clojure.test :as t]))

(t/deftest accounts-test
  (t/testing "happy"
    (let [a (ref 100)
          b (ref 200)]
      (dosync
       (alter a + 50)
       (alter b - 50))
      (t/is (= @a @b))))
  (t/testing "unhappy"
    (let [c (ref 100)
          d (ref 200)]
      (dosync
       (alter c + 50)
       (throw (ex-info "fake" {}))
       (alter d - 50))
      (t/is (= @c 100))
      (t/is (= @d 200)))))
