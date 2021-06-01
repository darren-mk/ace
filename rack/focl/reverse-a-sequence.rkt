

(define (last l)
  (if (null? (cdr l))
      (first l)
      (last (cdr l))))
(define (f1 l)


  )
	
(equal? (f1 '(1 2 3 4 5)) '(5 4 3 2 1))
(equal? (f1 (set 5 7 2 7)) '(7 5 2))
(equal? (f1 '('(1 2)'(3 4)'(5 6))) '('(5 6)'(3 4)'(1 2)))

