(defn original [n]
  (print "original run")
  (+ n 10))
(def original-memoized (memoize original))
(original-memoized 2) ;; => 12 ;; prints "original run"
(original-memoized 2);; => 12
(original-memoized 2);; => 12 
(original-memoized 5) ;; => 15 ;; prints "original run
