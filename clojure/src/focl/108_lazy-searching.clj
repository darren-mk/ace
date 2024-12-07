;; https://www.4clojure.com/problem/108

;; 1

(= 3 (__ [3 4 5]))
(= 4 (__ [1 2 3 4 5 6 7] [0.5 3/2 4 19]))
(= 7 (__ (range) (range 0 100 7/6) [2 3 5 7 11 13]))
(= 64 (__ (map #(* % % %) (range)) ;; perfect cubes
          (filter #(zero? (bit-and % (dec %))) (range)) ;; powers of 2
          (iterate inc 20))) ;; at least as large as 20
