#lang racket/base

;; https://4clojure.oxal.org/#/problem/134

;; 1
(define (f1 h k)
  (if (null? (hash-ref h k))
      #t
      #f))
(equal? #t (f1 (hash 'a null 'b 2) 'a)) ;; #t
(equal? #f (f1 (hash 'a null 'b 2) 'b)) ;; #t
;; (equal? #f (f1 (hash 'a null 'b 2) 'c)) ;; not working

(member 'a '('b 3))

;; 2
(define (f2 l k)
  (let* [(kf (member k (map car l)))
        (vf (filter (lambda (p) (equal? (car p) kf)) l))]
    (if (and kf (null? vf))
        #t
        #f)))
(equal? #t (f2 '((a . null) (b . 2)) 'a)) ;; #t
(equal? #f (f2 '((a . null) (b . 2)) 'b)) ;;  not working
(equal? #f (f2 '((a . null) (b . 2)) 'c)) ;; #t
