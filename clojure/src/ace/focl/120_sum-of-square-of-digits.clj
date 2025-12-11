;; https://4clojure.oxal.org/#/problem/120

;; 1
(require '[clojure.string :as str])
(defn smaller-than-squared-components? [n]
  (as-> n v
       (str v)
       (str/split v #"")
       (map #(Integer/parseInt %) v)
       (map #(* % %) v)
       (reduce + v)
       (< n v)))
(defn f1 [coll]
  (as-> coll v
    (map smaller-than-squared-components? v)
    (map #(if % 1 0) v)
    (reduce + v)))
(= 8 (f1 (range 10))) ;; => true
(= 19 (f1 (range 30))) ;; => true
(= 50 (f1 (range 100))) ;; => true
(= 50 (f1 (range 1000))) ;; => true
