;; https://www.4clojure.com/problem/20

;; 1
(defn f1 [coll]
  (let [index-second-to-last (- (count coll) 2)]
    (nth coll index-second-to-last)))
(= (f1 (list 1 2 3 4 5)) 4) ;; => true
(= (f1 ["a" "b" "c"]) "b") ;; => true
(= (f1 [[1 2] [3 4]]) [1 2]) ;; => true

;; 2
(defn f2 [coll]
  (-> coll reverse second))
(= (f2 (list 1 2 3 4 5)) 4) ;; => true 
(= (f2 ["a" "b" "c"]) "b") ;; => true
(= (f2 [[1 2] [3 4]]) [1 2]) ;; => true

;; 3
(defn f3 [coll]
  (let [m (apply hash-map (interleave (iterate inc 0) coll))
        k (- (apply max (keys m)) 1)]
    (get m k)))
(= (f3 (list 1 2 3 4 5)) 4) ;; => true
(= (f3 ["a" "b" "c"]) "b") ;; => true
(= (f3 [[1 2] [3 4]]) [1 2]) ;; => true 
