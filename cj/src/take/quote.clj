;; quote
;; use apostrophy
'(+ 1 2) ;; => (+ 1 2)
'(+ 1 ~(+ 1 1)) ;; => (+ 1 ~(+ 1 1)) ;; unquote doesn' work
