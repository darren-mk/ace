#lang racket

(define worker-thread
  (thread
   (lambda ()
     (let loop ()
       (match (thread-receive)
         [(? number? num)
          (printf "Processing ~a~n" num)
          (loop)]
         ['done
          (printf "Done~n")])))))

(thread-send worker-thread 1) ;; Processing 1
(thread-send worker-thread 2) ;; Processing 2
(thread-send worker-thread 'done) ;; Done
(thread-send worker-thread 1)
;; ; thread-send: target thread is not running

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
     (thread-send subtraction-thread
                  (list o1 o2 (current-thread)))]))

(for ([i (length worklist)])
  (displayln (thread-receive)))
;; 3 - 2 = 1
;; 4 - 1 = 3
;; 1 + 1 = 2
;; 2 + 2 = 4
