;; The pattern of waiting on a semaphore, working, and posting
;; to the semaphore can also be expressed using call-with-semaphore,
;; which has the advantage of posting to the semaphore
;; if control escapes (e.g., due to an exception):

#lang racket/base

(define output-semaphore
  (make-semaphore 1))

(define (make-thread name)
  (thread
   (lambda ()
     (for [(i 10)]
       (call-with-semaphore
        output-semaphore
        (lambda ()
          (printf "thread ~a: ~a~n" name i)))))))

(define threads
  (map make-thread '(A B C)))

(for-each thread-wait threads)

;; Semaphores are a low-level technique.
;; Often, a better solution is to restrict
;; resource access to a single thread.
;; For example, synchronizing access to
;; standard output might be better accomplished
;; by having a dedicated thread for printing output.
