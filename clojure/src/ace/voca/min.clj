(min 1 2 3) ;; => 1
(apply min [1 2 3]) ;; => 1

(defn min' [x & xs]
  (let [sm #(if (< %1 %2) %1 %2)]
    (if xs
      (apply min' (cons (sm x (first xs)) (rest xs)))
      x)))
(min' 1 2 3) ;; => 1
