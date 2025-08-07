(flatten [1 [2 3]]) ;; => (1 2 3)
(flatten '(1 2 3)) ;; => (1 2 3)
(flatten '(1 2 [3 (4 5)])) ;; => (1 2 3 4 5)
(flatten nil) ;; => ()

(defn flatten'
  ([col]
   (flatten' [] col))
  ([acc [x & xs]]
   (cond (nil? x) acc
         (sequential? x) (flatten' acc (concat x xs))
         :else (flatten' (conj acc x) xs))))
(flatten' '(1 2 [3 (4 5)] 6 [7])) ;; => [1 2 3 4 5 6 7]
(flatten' '(1 2 3)) ;; => (1 2 3)
(flatten' '(1 2 [3 (4 5)])) ;; => (1 2 3 4 5)
(flatten' nil) ;; => ()

(defn flatten-2
  ([l]
   (flatten-2 [] l))
  ([acc [x & xs]]
   (lazy-seq
    (cond (nil? x) acc
          (sequential? x) (flatten-2 acc (flatten-2 x))
          :else (flatten-2 (conj acc x) xs)))))
(flatten-2 [1 [2 3]]) ;; => (1 2 3)
(flatten-2 '(1 2 3)) ;; => (1 2 3)
(flatten-2 '(1 2 [3 (4 5)])) ;; => (1 2 3 4 5)
(flatten-2 nil) ;; => ()
(flatten-2 [[[[1]]]])

(flatten [[1 2] [3 4]])
(flatten-2 [[1 2] [3 4]])

(defn flatten-c
  ([l]
   (flatten-c [] l))
  ([acc [x & xs]]
   (cond (nil? x) acc
         (coll? x) (flatten-c acc (cons (flatten-c x) xs))
         :else (flatten-c (conj acc x) xs))))
(flatten-c [1 2])
(flatten-c [[[[1]]]])
(flatten-c [1 [2 3]]) ;; => (1 2 3)
(flatten-c '(1 2 3)) ;; => (1 2 3)
(flatten-c '(1 2 [3 (4 5)])) ;; => (1 2 3 4 5)
(flatten-c nil) ;; => ()

(value)
(coll? #{1})
