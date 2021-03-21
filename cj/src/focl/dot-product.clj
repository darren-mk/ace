;; https://www.4clojure.com/problem/143

;; 1
(range 3) ;; => (0 1 2)
(map #(get [2 5 6] %) [0 1 2]) ;; => (2 5 6)
(map #(* (get [2 5 6] %) (get [100 10 1] %)) [0 1 2]) ;; => (200 50 6)
(map #(* (get [2 5 6] %) (get [100 10 1] %)) (range 3)) ;; => (200 50 6)
(defn f1 [a b]
  (reduce
   +
   (map #(* (get a %)
            (get b %))
        (range (count a)))))
(= 0 (f1 [0 1 0] [1 0 0])) ;; => true
(= 3 (f1 [1 1 1] [1 1 1])) ;; => true
(= 32 (f1 [1 2 3] [4 5 6])) ;; => true
(= 256 (f1 [2 5 6] [100 10 1])) ;; => true

;; 2
(defn f2 [a b]
  (reduce
   +
   (map * a b)))
(map * [1 2] [3 4]) ;; => (3 8)
(= 0 (f2 [0 1 0] [1 0 0])) ;; => true
(= 3 (f2 [1 1 1] [1 1 1])) ;; => true
(= 32 (f2 [1 2 3] [4 5 6])) ;; => true
(= 256 (f2 [2 5 6] [100 10 1])) ;; => true

;; 3
(defn f3 [a b]
  (reduce (fn [v x] (+ v (* (first x) (second x))))
          0 (partition 2 (interleave a b))))
(interleave [1 2] [3 4]) ;; => (1 3 2 4)
(partition 2 '(1 3 2 4)) ;; => ((1 3) (2 4))
(f3 [1 2] [3 4])
(= 0 (f3 [0 1 0] [1 0 0])) ;; => true 
(= 3 (f3 [1 1 1] [1 1 1])) ;; => true
(= 32 (f3 [1 2 3] [4 5 6])) ;; => true 
(= 256 (f3 [2 5 6] [100 10 1])) ;; => true
