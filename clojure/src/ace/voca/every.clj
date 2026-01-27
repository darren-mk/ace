(ns ace.voca.every
  (:require
   [clojure.test :as t]))

(every? (fn [x] (odd? x)) [1 3 5 7])
;; => true

(every? (fn [x] (odd? x)) [1 3 5 6])
;; => false

(every? odd? [1 3 5 7])
;; => true

(every? true? [true true])
;; => true

(every? true? [true false])
;; => false

;; implementation 1
(defn every?' [p coll]
  (->> (for [item coll]
         (p item))
       (reduce #(and %1 %2) true)))
;; => #'user/every?-alt-1
(every?' odd? [1 3 5 7])
;; => true
(every?' odd? [1 2 3])
;; => false

(defn every?'' [pred col]
  (reduce (fn [b item]
            (and b (pred item)))
          true col))
(every?'' odd? [1 3 5 7]) ;; => true
(every?'' odd? [1 2 3]) ;; => false

(defn every?''' [pred [x & xs]]
  (cond (nil? x) true
        (false? (pred x)) false
        :else (every?''' pred xs)))
(every?''' odd? [1 3 5 7]) ;; => true
(every?''' odd? [1 2 3]) ;; => false

(defn every?'''' [pred col]
  (reduce (fn [b x] (and b (pred x))) true col))
(every?'''' odd? [1 3 5 7]) ;; => true
(every?'''' odd? [1 2 3]) ;; => false

(defn every?-e
  [pred [x & xs]]
  (cond (nil? x) true
        (not (pred x)) false
        :else (every?-e pred xs)))
(every?-e odd? [1 3 5 7]) ;; => true
(every?-e odd? [1 2 3]) ;; => false

(defn every?-f [pred [x & xs]]
  (cond (nil? x) true
        (pred x) (recur pred xs)
        :else false))

(t/deftest test-every?-f
  (t/testing "basic success and failure cases"
    (t/is (true? (every?-f even? [2 4 6])))
    (t/is (false? (every?-f even? [2 3 6]))))
  (t/testing "edge cases"
    (t/is (true? (every?-f even? [])))
    (t/is (true? (every?-f even? nil)))
    (t/is (false? (every?-f #(= % 1) [1 1 2]))))
  (t/testing "data type diversity"
    (t/is (true? (every?-f string? ["a" "b" "c"])))
    (t/is (false? (every?-f integer? [1 2 "3"])))))

(defn every?-g [pred xs]
  (reduce (fn [a x]
            (if a (pred x)
                (reduced false)))
          true xs))

(t/deftest test-every?-g-optimized
  (t/testing "Standard functional checks"
    (t/is (true? (every?-g even? [2 4 6])))
    (t/is (false? (every?-g even? [2 3 6]))))
  (t/testing "Short-circuiting verification"
    (t/is (false? (every?-g even? (cons 1 (range 1000000))))))
  (t/testing "Empty and nil input"
    (t/is (true? (every?-g even? [])))
    (t/is (true? (every?-g even? nil)))))
