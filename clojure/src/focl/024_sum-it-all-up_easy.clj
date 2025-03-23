;; https://4clojure.oxal.org/#/problem/24

;; Problem 24
;; Write a function which returns the sum of a sequence of numbers.
;; (= (__ [1 2 3]) 6)
;; (= (__ (list 0 -2 5 5)) 8)
;; (= (__ #{4 2 1}) 7)
;; (= (__ '(0 0 -1)) -1)
;; (= (__ '(1 10 3)) 14)

;; 1
(defn f1 [coll]
  (loop [c coll
         s 0]
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

;; 3
(defn f3 [coll]
  (reduce
   (fn [s v] (+ s v))
   0
   coll))
(= (f3 [1 2 3]) 6) ;; => true
(= (f3 (list 0 -2 5 5)) 8) ;; => true
(= (f3 #{4 2 1}) 7) ;; => true
(= (f3 '(0 0 -1)) -1) ;; => true
(= (f3 '(1 10 3)) 14) ;; => true

;; 4
(defn f4 [coll]
  (if (empty? coll)
    0
    (+ (first coll)
       (f4 (rest coll)))))
(= (f4 [1 2 3]) 6) ;; => true
(= (f4 (list 0 -2 5 5)) 8) ;; => true
(= (f4 #{4 2 1}) 7) ;; => true
(= (f4 '(0 0 -1)) -1) ;; => true
(= (f4 '(1 10 3)) 14) ;; => true

;;
(defn f5 [l]
  (reduce
   (fn [sum elem] (+ sum elem))
   0
   l)) ;; => #'user/f5
(= (f5 [1 2 3]) 6) ;; => true
(= (f5 (list 0 -2 5 5)) 8) ;; => true
(= (f5 #{4 2 1}) 7) ;; => true
(= (f5 '(0 0 -1)) -1) ;; => true
(= (f5 '(1 10 3)) 14) ;; => true

(defn f6 [l]
  (reduce + 0 l))
(= (f6 [1 2 3]) 6) ;; => true
(= (f6 (list 0 -2 5 5)) 8) ;; => true
(= (f6 #{4 2 1}) 7) ;; => true
(= (f6 '(0 0 -1)) -1) ;; => true
(= (f6 '(1 10 3)) 14) ;; => true
