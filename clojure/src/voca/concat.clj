(concat [1 2] [3 4 5]) ;; => (1 2 3 4 5)
(concat [1 2] '(:a :b :c) #{"x" "y"}) ;; => (1 2 :a :b :c "x" "y")
(concat [1 2] [3 4]) ;; => (1 2 3 4)
(apply concat [[1 2] [3 4]]) ;; => (1 2 3 4)
(concat [1 2] [3 4 5]) ;; => (1 2 3 4 5)
(concat [1 2] '(3 4 5)) ;; => (1 2 3 4 5)
(concat '(1 2) '(3 4 5)) ;; => (1 2 3 4 5)
(concat [1 2] #{3 4 5}) ;; => (1 2 4 3 5)
(concat #{1 2} #{3 4 5}) ;; => (1 2 4 3 5)
(concat {:a 1} [2 3 4]) ;; => ([:a 1] 2 3 4)
(concat {:a 1} {:b 2}) ;; => ([:a 1] [:b 2])
(concat [1 2] [3 4] [5 6]) ;; => (1 2 3 4 5 6)
(type (concat [1 2] [3 4])) ;; => clojure.lang.LazySeq

;; a
(defn concat' [& colls] ;; not working
  (cond (empty? colls) nil
        (empty? (first colls)) (concat' (rest colls))
        (= 1 (count colls)) (lazy-seq (cons (-> colls first first) (concat' (-> colls first rest))))
        :else (lazy-seq (cons (-> colls first first) (concat' (-> colls first rest) (rest colls))))))
(concat' [1 2] [3 4 5])
(concat' [1 2] '(:a :b :c) #{"x" "y"}) ;; => (1 2 :a :b :c "x" "y")
(concat' [1 2] [3 4]) ;; => (1 2 3 4)
(apply concat' [[1 2] [3 4]]) ;; => (1 2 3 4)
(concat' [1 2] [3 4 5]) ;; => (1 2 3 4 5)
(concat' [1 2] '(3 4 5)) ;; => (1 2 3 4 5)

(defn concat'' [& colls]
  (let [f (fn [acc x] (conj acc x))
        acc (first colls)
        feed (-> colls rest flatten)]
    (reduce f acc feed)))
(concat'' [1 2] [3 4 5]) ;; => [1 2 3 4 5]
(concat'' [1 2] '(:a :b :c) #{"x" "y"}) ;; => (1 2 :a :b :c "x" "y")
(concat'' [1 2] [3 4]) ;; => (1 2 3 4)
(apply concat'' [[1 2] [3 4]]) ;; => (1 2 3 4)
(concat'' [1 2] [3 4 5]) ;; => (1 2 3 4 5)
(concat'' [1 2] '(3 4 5)) ;; => (1 2 3 4 5)

(defn concat''' [a [x & xs]]
  (if-not x a (concat''' (conj a x) xs)))
(concat''' [1 2] [3 4 5]) ;; => [1 2 3 4 5]
(concat''' [1 2] [3 4]) ;; => [1 2 3 4]
(apply concat''' [[1 2] [3 4]]) ;; => [1 2 3 4]
(concat''' [1 2] [3 4 5]) ;; => [1 2 3 4 5]
(concat''' [1 2] '(3 4 5)) ;; => [1 2 3 4 5]
