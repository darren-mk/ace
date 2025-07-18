(drop 2 [5 6 7 8]) ;; => (7 8)
(drop 3 [5 6 7 8]) ;; => (8)
(drop 0 [2 3 4]) ;; => (2 3 4) 
(drop 4 [:a :b :c :d :e :f]) ;; => (:e :f)

(defn drop-1
  [n l]
  (if (zero? n) l
      (drop-1 (dec n) (rest l))))
(drop-1 2 [5 6 7 8]) ;; => (7 8)
(drop-1 3 [5 6 7 8]) ;; => (8)
(drop-1 0 [2 3 4]) ;; => (2 3 4) 
(drop-1 4 [:a :b :c :d :e :f]) ;; => (:e :f)
