#lang racket/base

;; https://4clojure.oxal.org/#/problem/10

(eq? 20 (hash-ref (hash 'a 10 'b 20 'c 30) 'b)) ;; #t
