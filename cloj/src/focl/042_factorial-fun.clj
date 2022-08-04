;; https://4clojure.oxal.org/#/problem/42

;; 1
(defn f1 [x]
  (loop [x x
         n 1]
    (if (= x 1)
      n
      (recur (dec x) (* n x)))))
(= (f1 1) 1) ;; => true
(= (f1 3) 6) ;; => true
(= (f1 5) 120) ;; => true
(= (f1 8) 40320) ;; => true
