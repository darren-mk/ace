(flatten [1 [2 3]])
;; => (1 2 3)

(flatten '(1 2 3))
;; => (1 2 3)

(flatten '(1 2 [3 (4 5)]))
;; => (1 2 3 4 5)

(flatten nil)
;; => ()

(flatten (seq {:name "Hubert" :age 23}))
;; => (:name "Hubert" :age 23)

(defn flatten'
  ([col]
   (flatten' [] col))
  ([acc [x & xs]]
   (cond (nil? x) acc
         (sequential? x) (flatten' acc (concat x xs))
         :else (flatten' (conj acc x) xs))))
(flatten' '(1 2 [3 (4 5)] 6 [7])) ;; => [1 2 3 4 5 6 7]
