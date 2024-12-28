(ns grokking-algorithms-2ed.01
  (:require
   [clojure.math :as math]))

(defn log2 [n]
  (/ (math/log n) (math/log 2)))

(comment
  (log2 10)
  :=> 3.3219280948873626)
