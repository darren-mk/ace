
(reduce (fn [acc x] (+ acc x))
        100 [1 2 3 4])
;; => 110

(defn reduce' [f v [x & xs]]
  (if-not x v
          (reduce' f (f v x) xs)))

(reduce' (fn [acc x] (+ acc x))
         100 [1 2 3 4])
;; => 110
