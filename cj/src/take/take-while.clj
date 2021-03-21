;; take from the beginning
(take-while neg? [-2 -1 0 1 2]) ;; => (-2 -1)
(filter neg? [-2 -1 0 1 2]) ;; => (-2 -1)
(take-while even? [-2 -1 0 1 2]) ;; => (-2)
(take-while even? [2 4 6 5]) ;; => (2 4 6)
(filter even? [1 2 4 6 5]) ;; => (2 4 6)
(take-while even? [1 2 4 6 5]) ;; => ()
