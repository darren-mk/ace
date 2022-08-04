;; quote
;; use apostrophy
'(+ 1 2) ;; => (+ 1 2)
'(+ 1 ~(+ 1 1)) ;; => (+ 1 ~(+ 1 1)) ;; unquote doesn' work

(read-string "'(:a :b :c)")
;; => '(:a :b :c)

(read-string "@v")
;; => @v
