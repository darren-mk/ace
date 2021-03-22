(require racket/contract)

(define/contract (reverse x)
  (-> exact-integer? exact-integer?)

  )


(define a 1)

(abs -11)

(->> -3
     abs)
