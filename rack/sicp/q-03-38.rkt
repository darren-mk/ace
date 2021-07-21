#lang racket

#|
https://mitpress.mit.edu/sites/default/files/sicp/full-text/book/book-Z-H-23.html#%_sec_3.4.1
Exercise 3.38.  Suppose that Peter, Paul, and Mary share a joint bank account that initially contains $100. Concurrently, Peter deposits $10, Paul withdraws $20, and Mary withdraws half the money in the account, by executing the following commands:
Peter: 	(set! balance (+ balance 10))
Paul: 	(set! balance (- balance 20))
Mary: 	(set! balance (- balance (/ balance 2)))
a. List all the different possible values for balance after these three transactions have been completed, assuming that the banking system forces the three processes to run sequentially in some order.
b. What are some other values that could be produced if the system allows the processes to be interleaved? Draw timing diagrams like the one in figure 3.29 to explain how these values can occur.
|#

(require threading)

(define balance 100)

(define (deposit-10 b)
  (+ b 10))

(define (withdraw-20 b)
  (- b 20))

(define (half-it b)
  (/ b 2))

(let ([combi (list deposit-10 withdraw-20 half-it)])
  (for ([a combi]
        [b combi]
        [c combi])
    (display (list a b c))))
