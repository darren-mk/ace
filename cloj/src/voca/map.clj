;; (map f) (map f coll) (map f c1 c2) (map f c1 c2 c3) (map f c1 c2 c3 & colls)

(map inc [1 2 3 4 5])
;; => (2 3 4 5 6)

(map + [1 2 3] [4 5 6])
;; => (5 7 9)

(map + [1 2 3] (iterate inc 1))
;; => (2 4 6)

(map + #{1 2 3})
;; => (1 3 2)

(map concat '((1) (2)) '((3) (4)))
;; => ((1 3) (2 4))

;; implementation of map using reduce

(type (map #(+ % 1) [1 2 3])) ;; => clojure.lang.LazySeq
(type (map #(+ % 1) '(1 2 3))) ;; => clojure.lang.LazySeq
(type (map #(+ % 1) #{1 2 3})) ;; => clojure.lang.LazySeq

(defn map-2 [f coll]
  (reduce
   (fn [new-coll item]
     (lazy-seq (cons (f item) new-coll)))
   '()
   (reverse coll)))

(map-2 #(+ % 1) '(1 2 3)) ;; => (2 3 4)
(map-2 #(+ % 1) [1 2 3]) ;; => (2 3 4)
(map-2 #(+ % 1) #{1 2 3}) ;; => (2 4 3)
