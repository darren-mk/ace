(defn original [n]
  (print "original run")
  (+ n 10))
(def original-memoized (memoize original))
(original-memoized 2) ;; => 12 ;; prints "original run"
(original-memoized 2);; => 12
(original-memoized 2);; => 12 
(original-memoized 5) ;; => 15 ;; prints "original run


(defn memoize-a [f]
  (let [db (atom {})]
    (fn [x]
      (let [stored (get @db x)]
        (if stored
          stored
          (let [v (f x)]
            (println "processed " x)
            (swap! db assoc x v)
            v))))))

(let [f (fn [x] (* x 1000000))
      memoize-a-f (memoize-a f)]
  (memoize-a-f 3)
  (memoize-a-f 3)
  (memoize-a-f 3))
;; processed  3 <- printed once
