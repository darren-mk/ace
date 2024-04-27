#lang racket

;; https://4clojure.oxal.org/#/problem/39

;; 1
(define (f1 a b)
  (define (iter a b r)
    (if (or (empty? a)
            (empty? b))
        r
        (iter (rest a)
              (rest b)
              (cons (first b) 
                    (cons (first a) r)))))
  (reverse (iter a b '())))
(equal? (f1 '(1 2 3) '(:a :b :c)) '(1 :a 2 :b 3 :c)) ;; #t
(equal? (f1 '(1 2) '(3 4 5 6)) '(1 3 2 4)) ;; #t
(equal? (f1 '(1 2 3 4) '(5)) '(1 5)) ;; #t
(equal? (f1 '(30 20) '(25 15)) '(30 25 20 15)) ;; #t

;; 2
;; map two lists after truncated and
;; flatten smaller lists by apply append.
(define (f2 a b)
  (let* [(mxl (min (length a)
                   (length b)))
         (al (take a mxl))
         (bl (take b mxl))]
    (apply append
           (map (lambda (a b) (list a b))
                al bl))))
(equal? (f2 '(1 2 3) '(:a :b :c)) '(1 :a 2 :b 3 :c)) ;; #t
(equal? (f2 '(1 2) '(3 4 5 6)) '(1 3 2 4)) ;; #t
(equal? (f2 '(1 2 3 4) '(5)) '(1 5)) ;; #t
(equal? (f2 '(30 20) '(25 15)) '(30 25 20 15)) ;; #t
