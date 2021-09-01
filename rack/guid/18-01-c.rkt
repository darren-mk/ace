;; https://docs.racket-lang.org/guide/concurrency.html

#lang racket/base

(define worker
  (thread
   (lambda ()
     (for ((i 100))
       (println 
        (string-append "Working hard ... "
                       (number->string i)))))))
(thread-wait worker)
(displayln "Worker finished")
