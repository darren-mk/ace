(require '[clojure.walk :as w])
;; => nil

(w/walk #(* 2 %) #(apply + %)
        [1 2 3 4 5]) ;; => 30
(->> [1 2 3 4 5]
     (map #(* 2 %))
     (apply +)) ;; => 30
(w/walk second #(apply max %)
        [[1 2] [3 4] [5 6]]) ;; => 6
(->> [[1 2] [3 4] [5 6]]
     (map second)
     (apply max)) ;; => 6
(w/walk first #(apply max %)
        [[1 2] [3 4] [5 6]]) ;; => 5
(->> [[1 2] [3 4] [5 6]]
     (map first)
     (apply max)) ;; => 5
(w/walk first reverse
        [[1 2] [3 4] [5 6]]) ;; => (5 3 1)
(->> [[1 2] [3 4] [5 6]]
     (map first)
     reverse) ;; => (5 3 1)

(defn walk' [inner outer col]
  (outer (map inner col)))
(walk' #(* 2 %) #(apply + %)
        [1 2 3 4 5]) ;; => 30
(walk' second #(apply max %)
        [[1 2] [3 4] [5 6]]) ;; => 6
(walk' first #(apply max %)
        [[1 2] [3 4] [5 6]]) ;; => 5
(walk' first reverse
        [[1 2] [3 4] [5 6]]) ;; => (5 3 1)
