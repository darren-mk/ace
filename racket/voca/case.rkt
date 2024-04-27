#lang racket/base

(define (luck n)
  (case n
    [(7 11 17 19) "lucky"]
    [(3 5 8) "complete"]
    [else "okay"]))

#|
case.rkt> (luck 3)
"complete"
case.rkt> 
case.rkt> (luck 3)
"complete"
case.rkt> (luck 19)
"lucky"
case.rkt> (luck 8)
"complete"
case.rkt> (luck 0)
"okay"
case.rkt> (luck "yahiuh")
"okay"
|#
