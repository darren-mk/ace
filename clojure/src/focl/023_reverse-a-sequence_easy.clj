;; https://4clojure.oxal.org/#/problem/23

;; Problem 23
;; Write a function which reverses a sequence.
;; (= (__ [1 2 3 4 5]) [5 4 3 2 1])
;; (= (__ (sorted-set 5 7 2 7)) '(7 5 2))
;; (= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])
;; Special Restrictions : reverse

;; 1
(defn f1 [seq]
  (loop [o seq r '()]
    (if (empty? o)
      r
      (recur (rest o)
             (conj r (first o))))))
(= (f1 [1 2 3 4 5]) [5 4 3 2 1]) ;; => true
(= (f1 (sorted-set 5 7 2 7)) '(7 5 2)) ;; => true
(= (f1 [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]) ;; => true

;; 2
(defn f2 [coll]
  (as-> coll c
    (zipmap (iterate dec (count c)) c)
    (sort c)
    (vals c)))
(= (f2 [1 2 3 4 5]) [5 4 3 2 1]) ;; => true
(= (f2 (sorted-set 5 7 2 7)) '(7 5 2)) ;; => true
(= (f2 [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]) ;; => true

;; 3
(defn f3 [coll]
  (vals 
   (sort   
    (zipmap (iterate dec 0) coll))))
(= (f3 [1 2 3 4 5]) [5 4 3 2 1]) ;; => true
(= (f3 (sorted-set 5 7 2 7)) '(7 5 2)) ;; => true
(= (f3 [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]) ;; => true

;; 4
(defn f4 [coll]
  (reduce
   (fn [new-coll elem] (cons elem new-coll))
   '()
   coll)) ;; => #'user/f4
(= (f4 [1 2 3 4 5]) [5 4 3 2 1]) ;; => true
(= (f4 (sorted-set 5 7 2 7)) '(7 5 2)) ;; => true
(= (f4 [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]) ;; => true

(defn f5
  ([col]
   (f5 col '()))
  ([[x & xs] reversed]
   (if x (recur xs (conj reversed x))
       reversed)))
(= (f5 [1 2 3 4 5]) [5 4 3 2 1]) ;; => true
(= (f5 (sorted-set 5 7 2 7)) '(7 5 2)) ;; => true
(= (f5 [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]) ;; => true
