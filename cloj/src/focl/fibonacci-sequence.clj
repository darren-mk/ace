;; https://www.4clojure.com/problem/26

;; 1
(defn f1 [n]
  (take n
        (map last 
             (iterate
              (fn [[x y]] [y (+ x y)])
              [0 1]))))
(= (f1 3) '(1 1 2));; => true
(= (f1 6) '(1 1 2 3 5 8));; => true
(= (f1 8) '(1 1 2 3 5 8 13 21));; => true

;; 2
(defn fib [x]
  (if (<= x 2)
    1
    (+ (fib (- x 1))
       (fib (- x 2)))))
(defn f2 [n]
  (map fib (range 1 (+ n 1))))
(= (f2 3) '(1 1 2)) ;; => true
(= (f2 6) '(1 1 2 3 5 8)) ;; => true
(= (f2 8) '(1 1 2 3 5 8 13 21)) ;; => true

;; 3
(defn f3 [n]
  (nth
   (iterate
    (fn [coll] (conj coll (+ (first (reverse coll))
                             (second (reverse coll)))))
    [1 1])
   (- n 2)))
(= (f3 3) '(1 1 2)) ;; => true
(= (f3 6) '(1 1 2 3 5 8)) ;; => true
(= (f3 8) '(1 1 2 3 5 8 13 21)) ;; => true
