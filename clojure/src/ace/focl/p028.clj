(ns ace.focl.p028
  (:require
   [clojure.test :as t]))

;; Write a function which flattens a sequence.
;; Special Restrictions : flatten

(defn run [f]
  (and (= (f '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
       (= (f ["a" ["b"] "c"]) '("a" "b" "c"))
       (= (f '((((:a))))) '(:a))))

(defn a [sq]
  (filter (fn [x] ((complement sequential?) x)) 
          (tree-seq sequential? identity sq)))

(defn b [sq]
  (filter (complement sequential?) 
          (tree-seq sequential? identity sq)))

(defn c [coll]
  (->> coll
       (tree-seq sequential? identity)
       (filter (complement sequential?))))

(defn d [l]
  (if (empty? l)
    nil
    (if (coll? (first l))
      (concat (d (first l)) (d (rest l)))
      (cons (first l) (d (rest l))))))

(defn e
  ([l]
   (e l []))
  ([[x & xs] acc]
   (cond (nil? x) acc
         (not (sequential? x)) (e xs (conj acc x))
         :else (e (concat (e x []) xs) acc))))

(t/deftest all
  (t/are [fnc] (run fnc)
    a b c d e))


