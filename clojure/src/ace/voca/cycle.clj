(ns ace.voca.cycle
  (:require
   [clojure.test :as t]))

(take 10 (cycle [1 2 3])) ;; => (1 2 3 1 2 3 1 2 3 1)
(take 10 (cycle #{1 2 3})) ;; => (1 3 2 1 3 2 1 3 2 1)
(take 10 (cycle '(1 2 3))) ;; => (1 2 3 1 2 3 1 2 3 1)
(take 10 (cycle (list 1 2 3))) ;; => (1 2 3 1 2 3 1 2 3 1)

(defn cycle-a [col]
  (lazy-cat col (cycle-a col)))
(take 10 (cycle-a [1 2 3]))
;; => (1 2 3 1 2 3 1 2 3 1)

(defn cycle-b [coll]
  (lazy-seq
   (concat coll (cycle-b coll))))
(take 10 (cycle-b [1 2 3]))
;; => (1 2 3 1 2 3 1 2 3 1)
