#lang racket

#|
https://docs.racket-lang.org/guide/concurrency.html
Channels synchronize two threads while a value is passed
from one thread to the other. Unlike a thread mailbox,
multiple threads can get items from a single channel,
so channels should be used when multiple threads need
to consume items from a single work queue.
|#

(define result-channel (make-channel))

(define result-thread
  (thread (lambda ()
            (let loop ()
              (display (channel-get result-channel))
              (loop)))))

(define work-channel (make-channel))

(define (make-worker thread-id)
  (thread
   (lambda ()
     (let loop ()
       (define item (channel-get work-channel))
       (case item
         [(DONE)
          (channel-put result-channel
                       (format "Thread ~a done\n" thread-id))]
         [else
          (channel-put result-channel
                       (format "Thread ~a processed ~a\n"
                               thread-id
                               item))
          (loop)])))))

(define work-threads (map make-worker '(1 2 3 4)))

(for ([item '(A B C D E F G H DONE DONE)])
  (channel-put work-channel item))
#|
Thread 1 processed D
Thread 1 processed E
Thread 2 processed C
Thread 3 processed B
Thread 4 processed A
Thread 4 processed F
Thread 1 done
Thread 2 done
Thread 3 processed H
Thread 4 processed G
|#

(for-each thread-wait work-threads)

(channel-put result-channel "")
