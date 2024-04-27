;; https://docs.racket-lang.org/guide/concurrency.html

;; Channels synchronize two threads while a value is passed
;; from one thread to the other. Unlike a thread mailbox,
;; multiple threads can get items from a single channel,
;; so channels should be used when multiple threads need to
;; consume items from a single work queue.

;; In the following example, the main thread adds items
;; to a channel using channel-put, while multiple worker threads
;; consume those items using channel-get.
;; Each call to either procedure blocks until another thread
;; calls the other procedure with the same channel.
;; The workers process the items and then pass their results
;; to the result thread via the result-channel.

#lang racket/base

(define result-channel
  (make-channel))

(define result-thread
  (thread
   (lambda ()
     (let loop ()
       (display
        (channel-get result-channel))
       (loop)))))

(define work-channel
  (make-channel))

(define (make-worker thread-id)
  (thread
   (lambda ()
     (let loop ()
       (define item
         (channel-get work-channel))
       (case item
         [(DONE)
          (channel-put result-channel
                       (format "Thread ~a done\n"
                               thread-id))]
         [else
          (channel-put result-channel
                       (format "Thread ~a processed ~a\n"
                               thread-id
                               item))
          (loop)])))))

(define work-threads
  (map make-worker '(1 2)))

(for ([item '(A B C D E F G H DONE DONE)])
  (channel-put work-channel item))

(for-each thread-wait work-threads)

(channel-put result-channel "")
; waits until result-thread has printed all other output
