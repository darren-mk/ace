;; https://www.4clojure.com/problem/67

;; 1
(defn is-prime? [n]
  (->> n
       inc
       (range 1)
       (filter #(= 0 (mod n %)))
       count
       (= 2)))
(is-prime? 5) ;; => true
(is-prime? 6) ;; => false
(defn f1 [n]
  (take n (filter is-prime? (iterate inc 1))))
(f1 5) ;; => (2 3 5 7 11)
(= (f1 2) [2 3]) ;; => true
(= (f1 5) [2 3 5 7 11]) ;; => true
(= (last (f1 100)) 541) ;; => true

;; 2
(= (__ 2) [2 3])
(= (__ 5) [2 3 5 7 11])
(= (last (__ 100)) 541)
