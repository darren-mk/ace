;; https://4clojure.oxal.org/#/problem/148

;; 1
(defn f1 [n d1 d2]
  (let [divisible? (fn [n d]
                     (= 0 (rem n d)))]
    (->> n
         range      
         (filter #(or (divisible? % d1)
                      (divisible? % d2)))
         (apply +))))
(= 0 (f1 3 17 11)) ;; => true
(= 23 (f1 10 3 5)) ;; => true
(= 233168 (f1 1000 3 5)) ;; => true
(= "2333333316666668" (str (f1 100000000 3 5))) ;; => true
(= "110389610389889610389610" (str (f1 (* 10000 10000 10000) 7 11))) ;; overflow
(= "1277732511922987429116" (str (f1 (* 10000 10000 10000) 757 809))) ;; overflow
(= "4530161696788274281" (str (f1 (* 10000 10000 1000) 1597 3571))) ;; overflow

;; 2
(defn f2 [n a b]
  (let [divisible? (fn [x divisor]
                     (zero? (rem x divisor)))]
    (->> (range n)
         (filter #(or (divisible? % a)
                      (divisible? % b)))
         (apply +))))
(= 0 (f2 3 17 11)) ;; => true
(= 23 (f2 10 3 5)) ;; => true
(= 233168 (f2 1000 3 5)) ;; => true
(= "2333333316666668" (str (f2 100000000 3 5))) ;; => true
(= "110389610389889610389610" (str (f2 (* 10000 10000 10000) 7 11))) ;; overflow
(= "1277732511922987429116" (str (f2 (* 10000 10000 10000) 757 809))) ;; overflow
(= "4530161696788274281" (str (f2 (* 10000 10000 1000) 1597 3571))) ;; overflow
