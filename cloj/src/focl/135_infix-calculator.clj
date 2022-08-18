;; https://www.4clojure.com/problem/135

;; 1
(defn f1 [& x]
  (reduce
   (fn [value process]
     ((first process) value (second process)))
   (first x)
   (partition 2 (rest x))))
(= 7 (f1 2 + 5)) ;; => true
(= 42 (f1 38 + 48 - 2 / 2)) ;; => true
(= 8 (f1 10 / 2 - 1 * 2)) ;; => true
(= 72 (f1 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9)) ;; => true

;; 2
(defn f2 [& x]
  (loop [l (rest x)
         r (first x)]
    (if (empty? l) r
          (let [f (first l)
                v (second l)]
            (recur (-> l rest rest)
                   (f r v))))))
(= 7 (f2 2 + 5)) ;; => true
(= 42 (f2 38 + 48 - 2 / 2)) ;; => true
(= 8 (f2 10 / 2 - 1 * 2)) ;; => true
(= 72 (f2 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9)) ;; => true
