(tree-seq sequential? identity '(1 2 (3 4)))
;; => ((1 2 (3 4)) 1 2 (3 4) 3 4)

(filter #(not (seq? %)) '((1 2 (3 4)) 1 2 (3 4) 3 4))
;; => (1 2 3 4)
