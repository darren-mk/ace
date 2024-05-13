;; https://www.4clojure.com/problem/66


;; mod
(mod 10 3);; => 1
;; zero?
(zero? 2) ;; => false
(zero? 0) ;; => true
;; recur
(defn test [n]
  (if (= n 5)
    n
    (recur (inc n))))
(test 0) ;; => 5

;; 1
;; https://stackoverflow.com/questions/32386047/greatest-common-divisor-in-clojure
[3 9] ;; => [3 9]
[9 (mod 3 9)] ;; => [9 3]
[3 (mod 9 3)] ;; => [3 0]
[0 3] ;; => [0 3]
[3 (mod 0 3)] ;; => [3 0]
3 ;; => 3 
(defn f1 [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))
(= (f1 2 4) 2) ;; => true
(= (f1 10 5) 5) ;; => true
(= (f1 5 7) 1) ;; => true
(= (f1 1023 858) 33) ;; => true

;; 2
(defn div-all? [nums d]
  (->> nums
       (filter #(zero? (rem % d)))
       count
       (= (count nums))))
(defn f1 [& nums]
  (->> nums
       (apply min)
       inc
       (range 1)
       (filter #(div-all? nums %))
       (apply max)))
(= (f1 2 4) 2) ;; => true
(= (f1 10 5) 5) ;; => true
(= (f1 5 7) 1) ;; => true
(= (f1 1023 858) 33) ;; => true
