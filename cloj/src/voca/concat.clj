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
(defn concat-a [& colls] ;; not working
  (cond (empty? colls) nil
        (empty? (first colls)) (concat-a (rest colls))
        (= 1 (count colls)) (lazy-seq (cons (-> colls first first) (concat-a (-> colls first rest))))
        :else (lazy-seq (cons (-> colls first first) (concat-a (-> colls first rest) (rest colls))))))
(concat-a [1 2] [3 4 5])
(concat-a [1 2] '(:a :b :c) #{"x" "y"}) ;; => (1 2 :a :b :c "x" "y")
(concat-a [1 2] [3 4]) ;; => (1 2 3 4)
(apply concat-a [[1 2] [3 4]]) ;; => (1 2 3 4)
(concat-a [1 2] [3 4 5]) ;; => (1 2 3 4 5)
(concat-a [1 2] '(3 4 5)) ;; => (1 2 3 4 5)

(defn concat-b [& colls]
  (let [f (fn [acc x] (conj acc x))
        acc (first colls)
        feed (-> colls rest flatten)]
    (reduce f acc feed)))
(concat-b [1 2] [3 4 5])
(concat-b [1 2] '(:a :b :c) #{"x" "y"}) ;; => (1 2 :a :b :c "x" "y")
(concat-b [1 2] [3 4]) ;; => (1 2 3 4)
(apply concat-b [[1 2] [3 4]]) ;; => (1 2 3 4)
(concat-b [1 2] [3 4 5]) ;; => (1 2 3 4 5)
(concat-b [1 2] '(3 4 5)) ;; => (1 2 3 4 5)
