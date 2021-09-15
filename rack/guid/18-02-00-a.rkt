;; https://docs.racket-lang.org/guide/concurrency.html

;; Each thread has a mailbox for receiving messages.
;; The thread-send function asynchronously sends
;; a message to another thread’s mailbox,
;; while thread-receive returns the oldest message
;; from the current thread’s mailbox,
;; blocking to wait for a message if necessary.
;; In the following example, the main thread sends
;; data to the worker thread to be processed,
;; then sends a 'done message when there is no more data
;; and waits for the worker thread to finish.

#lang racket/base

(require racket/match)

(define worker
  (thread
   (lambda ()
     (let loop ()
       (match (thread-receive)
         [(? number? num)
          (printf "Processing ~a~n" num)
          (loop)]
         ['done (printf "Done~n")])))))
;; worker thread created, start waiting

(for ([i 20])
  (thread-send worker i))
;; Processing 0
;; Processing 1
;; ...
;; Processing 18
;; Processing 19

(thread-send worker 'done)
;; Done

(thread-send worker 34)
;; thread-send: target thread is not running.

(thread-wait worker)
;; not sure what this does.
