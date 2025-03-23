;; https://4clojure.oxal.org/#/problem/19

;; Problem 19
;; Write a function which returns the last element in a sequence.
;; (= (__ [1 2 3 4 5]) 5)
;; (= (__ '(5 4 3)) 3)
;; (= (__ ["b" "c" "d"]) "d")
;; Special Restrictions : last

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

;; 4
(defn f4 [coll]
  (-> coll
      reverse
      first))
(= (f4 [1 2 3 4 5]) 5) ;; => true
(= (f4 '(5 4 3)) 3) ;; => true
(= (f4 ["b" "c" "d"]) "d") ;; => true

;; 5
(defn f5 [coll]
  (reduce
   (fn [a b] (if (nil? b) a b))
   coll)) ;; => #'user/f5
(= (f5 [1 2 3 4 5]) 5);; => true
(= (f5 '(5 4 3)) 3) ;; => true
(= (f5 ["b" "c" "d"]) "d") ;; => true

(defn f6 [[x & xs]]
  (if xs (recur xs) x))
(= (f6 [1 2 3 4 5]) 5);; => true
(= (f6 '(5 4 3)) 3) ;; => true
(= (f6 ["b" "c" "d"]) "d") ;; => true
