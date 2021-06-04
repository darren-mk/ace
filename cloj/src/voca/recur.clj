(defn count-2
  ([] 0)
  ([x] 1)
  ([x & xs] (+ 1 (count xs))))
