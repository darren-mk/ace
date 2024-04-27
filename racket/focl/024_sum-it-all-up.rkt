#lang racket/base

;; https://4clojure.oxal.org/#/problem/24

(require racket/set)

;; 1
(define (f1 l)
  (if (null? l)
      0
      (+ (car l) (f1 (cdr l)))))
(equal? (f1 (list 1 2 3)) 6) ;; #t
(equal? (f1 (list 0 -2 5 5)) 8) ;; #t
(equal? (f1 (set->list (set 4 2 1))) 7) ;; #t
(equal? (f1 '(0 0 -1)) -1) ;; #t
(equal? (f1 '(1 10 3)) 14) ;; #t

;; 2
(define (f2 l)
  (foldl + 0 l))
(equal? (f2 (list 1 2 3)) 6) ;; #t
(equal? (f2 (list 0 -2 5 5)) 8) ;; #t
(equal? (f2 (set->list (set 4 2 1))) 7) ;; #t
(equal? (f2 '(0 0 -1)) -1) ;; #t
(equal? (f2 '(1 10 3)) 14) ;; #t

;; 3
(define (f3 l)
  (foldr + 0 l))
(equal? (f3 (list 1 2 3)) 6) ;; #t
(equal? (f3 (list 0 -2 5 5)) 8) ;; #t
(equal? (f3 (set->list (set 4 2 1))) 7) ;; #t
(equal? (f3 '(0 0 -1)) -1) ;; #t
(equal? (f3 '(1 10 3)) 14) ;; #t






#|
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
