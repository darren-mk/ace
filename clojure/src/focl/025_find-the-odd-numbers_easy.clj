;; https://4clojure.oxal.org/#/problem/25

;; Problem 25
;; Write a function which returns only the odd numbers from a sequence.
;; (= (__ #{1 2 3 4 5}) '(1 3 5))
;; (= (__ [4 2 1 6]) '(1))
;; (= (__ [2 2 4 6]) '())
;; (= (__ [1 1 1 3]) '(1 1 1 3))

;; 1
(defn f1 [seq]
  (filter (fn [x] (= (rem x 2) 1))
          seq))
(= (f1 #{1 2 3 4 5}) '(1 3 5)) ;; => true
(= (f1 [4 2 1 6]) '(1)) ;; => true
(= (f1 [2 2 4 6]) '()) ;; => true
(= (f1 [1 1 1 3]) '(1 1 1 3)) ;; => true

;; 2
(defn f2 [coll]
  (filter odd? coll))
(= (f2 #{1 2 3 4 5}) '(1 3 5)) ;; => true
(= (f2 [4 2 1 6]) '(1)) ;; => true
(= (f2 [2 2 4 6]) '()) ;; => true
(= (f2 [1 1 1 3]) '(1 1 1 3)) ;; => true

;; 3
(defn f3 [coll]
  (loop [r []
         coll coll]
    (if (empty? coll)
      r
      (recur (if (odd? (first coll))
               (conj r (first coll) )
               r)
             (rest coll)))))
(= (f3 #{1 2 3 4 5}) '(1 3 5)) ;; => true
(= (f3 [4 2 1 6]) '(1)) ;; => true
(= (f3 [2 2 4 6]) '()) ;; => true
(= (f3 [1 1 1 3]) '(1 1 1 3)) ;; => true

;; 4
(defn f4 [l]
  (reduce
   (fn [odd-list elem]
     (if (odd? elem)
       (conj odd-list elem)
       odd-list))
   []
   l)) ;; => #'user/f4
(= (f4 #{1 2 3 4 5}) '(1 3 5)) ;; => true
(= (f4 [4 2 1 6]) '(1)) ;; => true
(= (f4 [2 2 4 6]) '()) ;; => true
(= (f4 [1 1 1 3]) '(1 1 1 3)) ;; => true

(defn f5 [l]
  (reduce (fn [a y] (if (odd? y) (conj a y) a)) [] l))
(= (f5 #{1 2 3 4 5}) '(1 3 5)) ;; => true
(= (f5 [4 2 1 6]) '(1)) ;; => true
(= (f5 [2 2 4 6]) '()) ;; => true
(= (f5 [1 1 1 3]) '(1 1 1 3)) ;; => true

(defn f6
  ([l]
   (f6 l []))
  ([[x & xs] acc]
   (if x (recur xs
                (if (odd? x) (conj acc x)
                    acc))
       acc)))
(= (f6 #{1 2 3 4 5}) '(1 3 5)) ;; => true
(= (f6 [4 2 1 6]) '(1)) ;; => true
(= (f6 [2 2 4 6]) '()) ;; => true
(= (f6 [1 1 1 3]) '(1 1 1 3)) ;; => true
