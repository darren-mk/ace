;; https://4clojure.oxal.org/#/problem/143

;; 1
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
(= 0 (f2 [0 1 0] [1 0 0])) ;; => true
(= 3 (f2 [1 1 1] [1 1 1])) ;; => true
(= 32 (f2 [1 2 3] [4 5 6])) ;; => true
(= 256 (f2 [2 5 6] [100 10 1])) ;; => true

;; 3
(defn f3 [a b]
  (reduce (fn [v x] (+ v (* (first x) (second x))))
          0 (partition 2 (interleave a b))))
(= 0 (f3 [0 1 0] [1 0 0])) ;; => true 
(= 3 (f3 [1 1 1] [1 1 1])) ;; => true
(= 32 (f3 [1 2 3] [4 5 6])) ;; => true 
(= 256 (f3 [2 5 6] [100 10 1])) ;; => true

;; 4
(defn f4 [a b]
  (apply + (map * a b)))
(= 0 (f4 [0 1 0] [1 0 0])) ;; => true 
(= 3 (f4 [1 1 1] [1 1 1])) ;; => true
(= 32 (f4 [1 2 3] [4 5 6])) ;; => true 
(= 256 (f4 [2 5 6] [100 10 1])) ;; => true

;;
(defn f5 [a b]
  (apply + (map * a b)))
(= 0 (f5 [0 1 0] [1 0 0])) ;; => true 
(= 3 (f5 [1 1 1] [1 1 1])) ;; => true
(= 32 (f5 [1 2 3] [4 5 6])) ;; => true 
(= 256 (f5 [2 5 6] [100 10 1])) ;; => true
