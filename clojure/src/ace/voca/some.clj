(ns ace.voca.some
  (:require
   [clojure.test :as t]))

;; clojure.core/some
;; ([pred coll])
;; Returns the first logical true value of (pred x) for any x in coll,
;; else nil.  One common idiom is to use a set as pred, for example
;; this will return :fred if :fred is in the sequence, otherwise nil:
;; (some #{:fred} coll)

(some even? [1 2 3 4 5 6])
;; => true
(some #(when (even? %) %) [1 2 3 4 5])
;; => 2
(some neg? [-1 2 5])
;; => true

(some neg? [1 2 3])

;; implementation 1
(defn some-alt-1 [p coll]
  (->> (for [item coll]
         (p item))
       (reduce
        (fn [a b] (or a b))
        false)))
;; => #'user/some-alt-1
(some-alt-1 even? [1 2 3 4 5 6])
;; => true
(some-alt-1 neg? [1 2 5])
;; => false

;; implementation 2
(defn some-alt-2 [p coll]
  (->> (for [item coll]
         (p item))
       (reduce #(or %1 %2)
               false)))
;; => #'user/some-alt-2
(some-alt-2 even? [1 2 3 4 5 6])
;; => true
(some-alt-2 neg? [1 2 5])
;; => false

(defn some-c [f coll]
  (reduce (fn [_ x]
            (if-let [res (f x)]
              (reduced res)
              nil))
          nil coll))

(t/deftest test-some-c
  (t/testing "Basic truthy checks"
    (t/is (= true (some-c even? [1 2 3])))
    (t/is (= nil (some-c even? [1 3 5]))))
  (t/testing "Returning non-boolean truthy values"
    (t/is (= "MATCH" (some-c #(when (= % 2) "MATCH") [1 2 3]))))
  (t/testing "Short-circuiting on infinite sequences"
    (t/is (= 0 (some-c identity (range))))))
