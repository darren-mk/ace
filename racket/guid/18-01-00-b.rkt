;; https://docs.racket-lang.org/guide/concurrency.html

#lang racket/base

(define consumer
  (thread
   (lambda ()
     (let loop ()  
       (displayln "working...")
       (sleep 0.2)
       (loop)))))
(sleep 3.0)
(kill-thread consumer)
