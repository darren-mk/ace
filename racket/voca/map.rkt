#lang racket/base

(require racket/list)

(map
 (lambda [x] (* x 10))
 (list 1 2 3))
;; '(10 20 30)

(define (map-alt-1 f l)
  ;; using racket/base only
  (if (null? l)
      '()
      (cons (f (car l))
            (map-alt-1 f (cdr l)))))
(map-alt-1 add1 '(1 2 3))
;; '(2 3 4)

(define (map-alt-2 f l)
  ;; using racket/list
  (if (empty? l)
      empty
      (cons (f (first l))
            (map-alt-2 f (rest l)))))
(map-alt-2 add1 '(1 2 3))
;; '(2 3 4)

(define (map-alt-3 f l)
  (define (iter f l r)
    (if (empty? l)
        r
        (iter f
              (rest l)
              (cons (f (first l))
                    r))))
  (reverse (iter f l empty)))
(map-alt-3 add1 '(1 2 3))
;; '(2 3 4)

(define (map-alt-4 f l)
  (for/list ([i l])
    (f i)))
(map-alt-4 add1 '(1 2 3))
;; '(2 3 4)
