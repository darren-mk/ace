#lang racket/base

(require racket/contract)

(provide
 (contract-out
  [amount (and/c number?
                 positive?)]))

;; (define amount 0) ;; contract violation
;; (define amount 'a) ;; contract violation
(define amount 1)
