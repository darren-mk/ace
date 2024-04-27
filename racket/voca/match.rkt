;; The bindings documented in this section are
;; provided by the racket/match and racket libraries,
;; but not racket/base.

#lang racket/base

(require racket/match)

(match "yes"
  ["no" 3]
  ["yes" 7])
;; 7

(define (m x)
  (match x
    [1 7]
    ['a 11]
    ["hi" 27]
    [else 0]))
;; 
(m 1)
;; 7
(m 'a)
;; 11
(m "hi")
;; 27
(m #f)
;; 0

(match 1
  [1 (println "hi") 100]
  [else "not 1"])
;; "hi"
;; 100
;; side-effect clause can be placed in between

(match 1
  [1 23 100]
  [else "not 1"])
;; 100
;; the inserted item, 23 here, is considered
;; side-effect clause, so it doesn't impact
;; the returned value 100.

(match 1
  [1 (println "hi") (println "me")]
  [else "not 1"])
;; "hi"
;; "me"
