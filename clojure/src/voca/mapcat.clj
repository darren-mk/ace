;; Returns the result of applying concat
;; to the result of applying map to f and colls.
;; Thus function f should return a collection.
;; Returns a transducer when no collections are provided.

(map (fn [x] (+ x 1)) [1 2 3 4])
;; => (2 3 4 5)

(reverse [[3 2 1 0] [6 5 4] [9 8 7]])
;; => ([9 8 7] [6 5 4] [3 2 1 0])

(mapcat reverse [[3 2 1 0] [6 5 4] [9 8 7]])
;; => (0 1 2 3 4 5 6 7 8 9)

;; same as
(apply concat
       (map reverse
            [[3 2 1 0] [6 5 4] [9 8 7]]))
;; => (0 1 2 3 4 5 6 7 8 9)

(defn mapcat' [f l]
  (apply concat (map f l)))
(= '(0 1 2 3 4 5 6 7 8 9)
   (mapcat' reverse [[3 2 1 0] [6 5 4] [9 8 7]])) :=> true
