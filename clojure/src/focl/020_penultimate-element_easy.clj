;; https://4clojure.oxal.org/#/problem/20

;; Problem 20
;; Write a function which returns the second to last element from a sequence.
;; (= (__ (list 1 2 3 4 5)) 4)
;; (= (__ ["a" "b" "c"]) "b")
;; (= (__ [[1 2] [3 4]]) [1 2])

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

;; 4
(defn f4 [coll]
  (-> coll
      reverse
      second)) ;; => #'user/f4
(= (f4 (list 1 2 3 4 5)) 4) ;; => true
(= (f4 ["a" "b" "c"]) "b") ;; => true
(= (f4 [[1 2] [3 4]]) [1 2]) ;; => true

;; 5
(defn f5 [coll]
  (let [v (into [] coll)]
    (get v 
         (-> v
             count
             dec
             dec)))) ;; => #'user/f5
(= (f5 (list 1 2 3 4 5)) 4) ;; => true
(= (f5 ["a" "b" "c"]) "b") ;; => true
(= (f5 [[1 2] [3 4]]) [1 2]) ;; => true
