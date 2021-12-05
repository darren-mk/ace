;; https://4clojure.oxal.org/#/problem/85

#lang racket

;; 1


(equal? (f1 (set 1 :a)) (set (set 1 :a) (set :a) (set) (set 1))) ;;
(equal? (f1 (set)) (set (set))) ;;
(equal? (f1 (set 1 2 3))
   (set (set) (set 1) (set 2) (set 3) (set 1 2) (set 1 3) (set 2 3) (set 1 2 3))) ;;
;; (equal? (count (f1 (into (set) (range 10)))) 1024)
;; equal?> true
