(ns ace.focl.p091
  (:require
   [clojure.test :as t]))

;; Given a graph, determine whether the graph is connected.
;; A connected graph is such that a path exists between any
;; two given nodes. -Your function must return true if the
;; graph is connected and false otherwise. -You will be given
;; a set of tuples representing the edges of a graph.
;; Each member of a tuple being a vertex/node in the graph.
;; Each edge is undirected (can be traversed either direction).

(defn run [f]
  (and (= true (f #{[:a :a]}))
       (= true (f #{[:a :b]}))
       (= false (f #{[1 2] [2 3] [3 1]
                     [4 5] [5 6] [6 4]}))
       (= true (f #{[1 2] [2 3] [3 1]
                    [4 5] [5 6] [6 4] [3 4]}))
       (= false (f #{[:a :b] [:b :c] [:c :d]
                     [:x :y] [:d :a] [:b :e]}))
       (= true (f #{[:a :b] [:b :c] [:c :d]
                    [:x :y] [:d :a] [:b :e] [:x :a]}))))

(defn ->adjs [edges]
  (-> (fn [acc [src dst]]
        (update acc src #(conj % dst)))
      (reduce {} edges)))
