;; quote
(quote (+ 1 2)) ;; => (+ 1 2)
(eval (quote (+ 1 2))) ;; => 3

;; use apostrophy
'(+ 1 2) ;; => (+ 1 2)
'(+ 1 ~(+ 1 1)) ;; => (+ 1 ~(+ 1 1)) ;; unquote doesn' work
