;; drop-while
;; drop from the beginning consecutively
(drop-while even? [2 4 5 7]) ;; => (5 7)
(drop-while even? [1 4 5 7]) ;; => (1 4 5 7)
(filter #(not (even? %)) [1 4 5 7]) ;; => (1 5 7)
