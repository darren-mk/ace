;; https://4clojure.oxal.org/#/problem/4

;; Problem 4
;; Lists can be constructed with either
;; a function or a quoted form.
;; (= (list __) '(:a :b :c))

#lang typed/racket/base

;; 1
(equal? (list 'a 'b 'c)
        '(a b c)) ;; #t
