;; Semaphores facilitate synchronized access
;; to an arbitrary shared resource.
;; Use semaphores when multiple threads must
;; perform non-atomic operations on a single resource.

;; In the following example, multiple threads
;; print to standard output concurrently.
;; Without synchronization, a line printed
;; by one thread might appear in the middle of
;; a line printed by another thread.
;; By using a semaphore initialized with
;; a count of 1, only one thread will print at a time.
;; The semaphore-wait function blocks
;; until the semaphore’s internal counter is non-zero,
;; then decrements the counter and returns.
;; The semaphore-post function increments the counter
;; so that another thread can unblock and then print.

#lang racket/base

(define output-semaphore
  (make-semaphore 1))

(define (make-thread name)
  (thread
   (lambda ()
     (for [(i 10)]
       (semaphore-wait output-semaphore)
       (printf "thread ~a: ~a~n" name i)
       (semaphore-post output-semaphore)))))

(define threads
  (map make-thread '(A B C)))

(for-each thread-wait threads)
