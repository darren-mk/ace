(mod 9 2) ;; => 1

(defn mod' [n d]
  (if (< n d) n
      (mod' (- n d) d)))
(mod' 9 2) ;; => 1
