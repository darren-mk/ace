;; In the next example, the main thread delegates
;; work to multiple arithmetic threads, then
;; waits to receive the results.
;; The arithmetic threads process work items
;; then send the results to the main thread.

#lang racket/base

(require racket/match)

(define (make-arithmetic-thread operation)
  (thread (lambda ()
            (let loop ()
              (match (thread-receive)
                [(list oper1 oper2 result-thread)
                 (thread-send result-thread
                              (format "~a ~a ~a = ~a"
                                      oper1
                                      (object-name operation)
                                      oper2
                                      (operation oper1 oper2)))
                 (loop)])))))

(define addition-thread (make-arithmetic-thread +))
(define subtraction-thread (make-arithmetic-thread -))

(define worklist '((+ 1 1) (+ 2 2) (- 3 2) (- 4 1)))

(for ([item worklist])
  (match item
    [(list '+ o1 o2)
     (thread-send addition-thread
                  (list o1 o2 (current-thread)))]
    [(list '- o1 o2)
     (thread-send addition-thread
                  (list o1 o2 (current-thread)))]))
;; not output at this point of evaluation

(for ([i (length worklist)])
  (displayln (thread-receive)))
;; 2 + 3 = 5
;; 2 + 3 = 5
;; 1 + 1 = 2
;; 2 + 2 = 4
