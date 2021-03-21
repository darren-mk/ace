;; https://www.4clojure.com/problem/24

;; 1
(defn f1 [coll]
  (loop [c coll s 0]
    (if (empty? c)
      s
      (recur
       (rest c) (+ s (first c))))))

(= (f1 [1 2 3]) 6) ;; => true
(= (f1 (list 0 -2 5 5)) 8) ;; => true
(= (f1 #{4 2 1}) 7) ;; => true
(= (f1 '(0 0 -1)) -1) ;; => true
(= (f1 '(1 10 3)) 14) ;; => true

;; 2
(defn f2 [coll]
  (reduce
   (fn [result elem] (+ result elem))
   0
   coll))
(= (f2 [1 2 3]) 6) ;; => true
(= (f2 (list 0 -2 5 5)) 8) ;; => true
(= (f2 #{4 2 1}) 7) ;; => true
(= (f2 '(0 0 -1)) -1) ;; => true
(= (f2 '(1 10 3)) 14) ;; => true
