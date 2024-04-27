(loop [r (range 50)
       s 0]
  (if (empty? r)
    s
    (recur (rest r) (+ s (first r)))))
;; => 1225
