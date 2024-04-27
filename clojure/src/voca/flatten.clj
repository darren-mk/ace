(flatten [1 [2 3]])
;; => (1 2 3)

(flatten '(1 2 3))
;; => (1 2 3)

(flatten '(1 2 [3 (4 5)]))
;; => (1 2 3 4 5)

(flatten nil)
;; => ()

(flatten (seq {:name "Hubert" :age 23}))
;; => (:name "Hubert" :age 23)
