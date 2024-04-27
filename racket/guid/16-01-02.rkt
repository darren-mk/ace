#lang racket

(define-syntax-rule (swap x y)
  (let ([tmp x])
    (set! x y)
    (set! y tmp)))

(let ([tmp 5]
      [other 6])
  (swap tmp other)
  (list tmp other))
;; '(6 5)

(let ([tmp 5]
      [other 6])
  (let ([tmp tmp])
    (set! tmp other)
    (set! other tmp))
  (list tmp other))
;; '(5 6)

;; Racket doesn’t produce the naive expansion for the above use of swap.
;; Instead, it produces

(let ([tmp 5]
      [other 6])
  (let ([tmp_1 tmp])
    (set! tmp other)
    (set! other tmp_1))
  (list tmp other))
;; '(6 5)
