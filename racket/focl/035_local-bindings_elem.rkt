#lang racket

;; https://4clojure.oxal.org/#/problem/35

;; 1
(= 7 (let [(x 5)] (+ 2 x))) ;; #t
(= 7 (let [(x 3) (y 10)] (- y x))) ;; #t
(= 7 (let [(x 21)] (let [(y 3)] (/ x y)))) ;; #t
