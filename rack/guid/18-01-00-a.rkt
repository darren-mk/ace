;; https://docs.racket-lang.org/guide/concurrency.html

#lang racket/base

(displayln "this is the original thread")
(thread (lambda ()
          (sleep 1.0)
          (displayln "this is the first new thread, but comming late.")))
(thread (lambda ()
          (displayln "this is another new thread, but without delay.")))
;; this is the original thread
;; #<thread:...rack/guid/18-01.rkt:6:8>
;; #<thread:...rack/guid/18-01.rkt:9:8>
;; this is another new thread, but without delay.
;; is the first new thread, but comming late.
