#lang racket/base

(require racket/contract)

(provide
 (contract-out
  [amount positive?]))

(define amount 3)
;; (define amount -3) ;; contract broken

