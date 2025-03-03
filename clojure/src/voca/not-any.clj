(not-any? odd? [2 4 6]) ;; => true
(not-any? odd? [2 4 6 7]) ;; => false

(defn not-any?' [f col]
  (let [f (fn [b item] (and b (not (f item))))]
    (reduce f true col)))
(not-any?' odd? [2 4 6]) ;; => true
(not-any?' odd? [2 4 6 7]) ;; => false
