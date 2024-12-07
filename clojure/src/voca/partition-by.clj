(partition-by odd? [1 1 2 2 3 3])
;; => ((1 1) (2 2) (3 3))

(partition-by odd? [1 1 2 2 1 1])
;; => ((1 1) (2 2) (1 1))

(partition-by identity [1 1 2 3 4])
;; => ((1 1) (2) (3) (4))

(partition-by identity "Leerrroyy")
;; => ((\L) (\e \e) (\r \r \r) (\o) (\y \y))

(partition-by #(< % 3) [1 2 2 2 3 3 4 4 5 5 2])
;; => ((1 2 2 2) (3 3 4 4 5 5) (2))

(partition-by pos? [-3 -2 -3 0 1 2 3])
;; => ((-3 -2 -3 0) (1 2 3))
