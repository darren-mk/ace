;; https://www.4clojure.com/problem/147

;; 1
(defn f1 [coll]
  (lazy-seq
   (cons coll
         (f1 (vec (map +'
                       (cons 0 coll)
                       (conj coll 0)))))))
(= (second (f1 [2 3 2]))
   [2 5 5 2]) ;; => true
(= (take 5 (f1 [1]))
   [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]]) ;; => true
(= (take 2 (f1 [3 1 2]))
   [[3 1 2] [3 4 3 2]]) ;; => true
(= (take 100 (f1 [2 4 2]))
   (rest (take 101 (f1 [2 2])))) ;; => true
