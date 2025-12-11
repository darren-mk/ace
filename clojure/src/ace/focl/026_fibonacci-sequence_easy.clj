;; https://4clojure.oxal.org/#/problem/26

;; Problem 26
;; Write a function which returns the first X fibonacci numbers.
;; (= (__ 3) '(1 1 2))
;; (= (__ 6) '(1 1 2 3 5 8))
;; (= (__ 8) '(1 1 2 3 5 8 13 21))

;; 1
(defn f1 [n]
  (take n
        (map last 
             (iterate
              (fn [[x y]] [y (+ x y)])
              [0 1]))))
(= (f1 3) '(1 1 2));; => true
(= (f1 6) '(1 1 2 3 5 8));; => true
(= (f1 8) '(1 1 2 3 5 8 13 21));; => true

;; 2
(defn fib [x]
  (if (<= x 2)
    1
    (+ (fib (- x 1))
       (fib (- x 2)))))
(defn f2 [n]
  (map fib (range 1 (+ n 1))))
(= (f2 3) '(1 1 2)) ;; => true
(= (f2 6) '(1 1 2 3 5 8)) ;; => true
(= (f2 8) '(1 1 2 3 5 8 13 21)) ;; => true
(time (f2 20))

;; 3
(defn f3 [n]
  (nth
   (iterate
    (fn [coll]
      (conj coll
            (+ (first (reverse coll))
               (second (reverse coll)))))
    [1 1])
   (- n 2)))
(= (f3 3) '(1 1 2)) ;; => true
(= (f3 6) '(1 1 2 3 5 8)) ;; => true
(= (f3 8) '(1 1 2 3 5 8 13 21)) ;; => true
(time (f3 20))

(defn f [x]
  (case x
    1 1
    2 1
    (+ (f (- x 1))
       (f (- x 2)))))
(def mf (memoize f))
(defn f4
  ([n]
   (f4 n []))
  ([n acc]
   (if (< n 1) acc 
       (f4 (dec n) (cons (mf n) acc)))))
(= (f4 3) '(1 1 2)) ;; => true
(= (f4 6) '(1 1 2 3 5 8)) ;; => true
(= (f4 8) '(1 1 2 3 5 8 13 21)) ;; => true
(time (f4 20))

(defn f5 [n]
  (map #(mf (inc %)) (range n)))
(= (f5 3) '(1 1 2)) ;; => true
(= (f5 6) '(1 1 2 3 5 8)) ;; => true
(= (f5 8) '(1 1 2 3 5 8 13 21)) ;; => true
(time (f5 20))
