(not-every? odd? [1 3]) ;; => false
(not-every? odd? [1 2 3]) ;; => true

(defn not-every?' [pred [x & xs]]
  (cond (not (pred x)) true
        xs (not-every? pred xs)
        :else false))
(not-every?' odd? [1 3]) ;; => false
(not-every?' odd? [1 2 3]) ;; => true
