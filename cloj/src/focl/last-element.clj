;; https://www.4clojure.com/problem/19

;; 1
(defn f1 [coll]
  (nth coll (- (count coll) 1)))

(= (f1 [1 2 3 4 5]) 5) ;; => true
(= (f1 '(5 4 3)) 3) ;; => true
(= (f1 ["b" "c" "d"]) "d") ;; => true

;; 2
(defn f2 [coll]
  (-> coll
      reverse
      first))
(= (f2 [1 2 3 4 5]) 5) ;; => true
(= (f2 '(5 4 3)) 3) ;; => true
(= (f2 ["b" "c" "d"]) "d") ;; => true

;; 3
(defn f3 [coll]
  (let [m (apply hash-map (interleave (iterate inc 0) coll))
        k (apply max (keys m))]
    (get m k)))
(= (f3 [1 2 3 4 5]) 5) ;; => true
(= (f3 '(5 4 3)) 3) ;; => true
(= (f3 ["b" "c" "d"]) "d") ;; => true
