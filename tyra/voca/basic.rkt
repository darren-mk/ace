#lang typed/racket

(define a 1)

(: pass (-> Integer Integer))
(define (pass x)
  x)

(: condit (-> Integer Integer))
(define (condit x)
  (if (> x 3) (pass 1) (pass 2)))


(time 
 (for ((x (range (* 1000 1000 1000))))
   (pass x)))
