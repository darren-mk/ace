(take 10 (cycle [1 2 3])) ;; => (1 2 3 1 2 3 1 2 3 1)
(take 10 (cycle #{1 2 3})) ;; => (1 3 2 1 3 2 1 3 2 1)
(take 10 (cycle '(1 2 3))) ;; => (1 2 3 1 2 3 1 2 3 1)
(take 10 (cycle (list 1 2 3))) ;; => (1 2 3 1 2 3 1 2 3 1)

(defn cycle' [col]
  (lazy-cat col (cycle' col)))
(take 10 (cycle' [1 2 3]))
;; => (1 2 3 1 2 3 1 2 3 1)
