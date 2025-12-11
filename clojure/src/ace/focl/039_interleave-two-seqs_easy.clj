;; https://www.4clojure.com/problem/39

;; 1
(defn f1 [a-coll b-coll]
  (let [shorter (min (count a-coll)
                     (count b-coll))]
    (loop [i 0
           l []]
      (if (>= i shorter)
        l      
        (recur (inc i)
               (conj l
                     (nth a-coll i)
                     (nth b-coll i)))))))
(= (f1 [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)) ;; => true 
(= (f1 [1 2] [3 4 5 6]) '(1 3 2 4)) ;; => true 
(= (f1 [1 2 3 4] [5]) [1 5]) ;; => true
(= (f1 [30 20] [25 15]) [30 25 20 15]) ;; => true

;; 2
(defn f2 [a b]
  (mapcat (fn [x y] [x y]) a b))
(= (f2 [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)) ;; => true 
(= (f2 [1 2] [3 4 5 6]) '(1 3 2 4)) ;; => true 
(= (f2 [1 2 3 4] [5]) [1 5]) ;; => true
(= (f2 [30 20] [25 15]) [30 25 20 15]) ;; => true
