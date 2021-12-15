#lang racket/base

(require racket/contract
         threading)

;; 1
(define/contract (plus-one-1 digits)
  (-> (listof exact-integer?) (listof exact-integer?))
  (~>> digits
       (map number->string)
       (apply string-append)
       (string->number)
       (add1)
       (number->string)
       (string->list)
       (map string)
       (map string->number)))
(plus-one-1 (list 1 2 3))
(plus-one-1 (list 4 3 2 1))
(plus-one-1 (list 0))

;; 2
(define/contract (plus-one-2 digits)
  (-> (listof exact-integer?) (listof exact-integer?))
  (map string->number
       (map string
            (string->list
             (number->string
              (add1 (string->number
                     (apply string-append
                            (map number->string digits)))))))))
(plus-one-2 (list 1 2 3))
(plus-one-2 (list 4 3 2 1))
(plus-one-2 (list 0))
