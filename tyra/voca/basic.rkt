#lang typed/racket

(define a 1)

(: pass (-> Integer Integer))
(define (pass x)
  x)

(: condit (-> Integer Integer))
(define (condit x)
  (if (> x 3) (pass 1) (pass 2)))

(define (test-run)
  (time
   (for ((x (range (* 1000 1000 1000))))
     (pass x))))
;; cpu time: 3811 real time: 3907 gc time: 19
;; cpu time: 3728 real time: 3820 gc time: 6
;; cpu time: 3746 real time: 3839 gc time: 23

(define (add-one [x : Real])
  (+ x 1))
