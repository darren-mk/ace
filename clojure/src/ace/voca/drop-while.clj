;; drop-while
;; drop from the beginning consecutively
(drop-while even? [2 4 5 7]) ;; => (5 7)
(drop-while even? [1 4 5 7]) ;; => (1 4 5 7)
(filter #(not (even? %)) [1 4 5 7]) ;; => (1 5 7)

(defn drop-while'
  ([pred col]
   (drop-while' pred col []))
  ([pred col acc]
   (cond (empty? col) (seq acc)
         (-> col first pred) (drop-while' pred (rest col) acc)
         :else (drop-while' pred (rest col) (conj acc (first col))))))
(drop-while' even? [2 4 5 7]) ;; => (5 7)
(drop-while' even? [1 4 5 7]) ;; => (1 5 7)

(defn drop-while-2
  [pred [x & xs :as l]]
  (lazy-seq
   (if-not (pred x) l
           (drop-while-2
            pred xs))))
(drop-while-2 even? [2 4 5 7]) ;; => (5 7)
(drop-while-2 even? [1 4 5 7]) ;; => (1 4 5 7)
(filter #(not (even? %)) [1 4 5 7]) ;; => (1 5 7)

