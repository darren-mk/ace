;; https://4clojure.oxal.org/#/problem/38

;; 1
(defn f1 [& nums]
  (loop [max 0 coll nums]
    (if (empty? coll)
      max
      (recur (if (> (first coll) max) (first coll) max)
             (rest coll)))))
(= (f1 1 8 3 4) 8) ;; => true
(= (f1 30 20) 30) ;; => true
(= (f1 45 67 11) 67) ;; => true

;; 2
(defn f2 [& nums]
  (reduce
   (fn [v n] (if (< v n) n v))
   nums))
(= (f2 1 8 3 4) 8) ;; => true
(= (f2 30 20) 30) ;; => true
(= (f2 45 67 11) 67) ;; => true

;; c
(defn f-c [& ns]
  (reduce (fn [max x] (if (< max x) x max)) ns))
(= (f-c 1 8 3 4) 8) ;; => true
(= (f-c 30 20) 30) ;; => true
(= (f-c 45 67 11) 67) ;; => true
