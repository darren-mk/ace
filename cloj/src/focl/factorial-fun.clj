;; https://www.4clojure.com/problem/42

;; 1
(defn f1 [n]
  (loop [i n
         r 1]
    (if (<= i 1)
      r
      (recur
       (- i 1)
       (* r i)))))
(= (f1 1) 1) ;; => true
(= (f1 3) 6) ;; => true
(= (f1 5) 120) ;; => true
(= (f1 8) 40320) ;; => true

;; 2
(take 3 (iterate dec 3)) ;; => (3 2 1)
(reduce * '(1 2 3)) ;; => 6
(reduce * (take 3 (iterate dec 3)));; => 6
(defn f2 [n]
  (reduce *
          (take n
                (iterate dec n))))
(= (f2 1) 1) ;; => true
(= (f2 3) 6) ;; => true
(= (f2 5) 120) ;; => true 
(= (f2 8) 40320) ;; => true 

;; 3
(defn f3 [n]
  (->> n
      (iterate dec)
      (take n)
      (reduce *)))
(= (f3 1) 1) ;; => true
(= (f3 3) 6) ;; => true
(= (f3 5) 120) ;; => true  
(= (f3 8) 40320) ;; => true

;; 4
(defn f4 [n]
  (reduce * (take n (iterate inc 1))))
(= (f4 1) 1) ;; => true
(= (f4 3) 6) ;; => true
(= (f4 5) 120) ;; => true
(= (f4 8) 40320) ;; => true
