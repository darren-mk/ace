#lang racket/base

;; https://4clojure.oxal.org/#/problem/25

;; 1
(define (f1 l)
  (filter (lambda (x) (odd? x)) l))
(equal? (f1 '(1 2 3 4 5)) '(1 3 5)) ;; #t
(equal? (f1 '(4 2 1 6)) '(1)) ;; #t
(equal? (f1 '(2 2 4 6)) '()) ;; #t
(equal? (f1 '(1 1 1 3)) '(1 1 1 3)) ;; #t

;; 2
(define (f2 l)
  (if (null? l)
      l
      (if (odd? (car l))
          (cons (car l) (f2 (cdr l)))
          (f2 (cdr l)))))
(equal? (f2 '(1 2 3 4 5)) '(1 3 5)) ;; #t
(equal? (f2 '(4 2 1 6)) '(1)) ;; #t
(equal? (f2 '(2 2 4 6)) '()) ;; #t
(equal? (f2 '(1 1 1 3)) '(1 1 1 3)) ;; #t

#|
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
|#
