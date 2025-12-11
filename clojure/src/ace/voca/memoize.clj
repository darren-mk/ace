(defn original [n]
  (print "original run")
  (+ n 10))
(def original-memoized (memoize original))
(original-memoized 2) ;; => 12 ;; prints "original run"
(original-memoized 2);; => 12
(original-memoized 2);; => 12 
(original-memoized 5) ;; => 15 ;; prints "original run

(defn memoize' [f]
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
      memoize-a-f (memoize' f)]
  (memoize-a-f 3)
  (memoize-a-f 3)
  (memoize-a-f 3))
;; processed  3 <- printed once

(defn memoize'' [f]
  (let [cache (atom {})]
    (fn [x]
      (if-let [existing (get @cache x)]
        existing
        (let [new (f x)]
          (swap! cache assoc x new)
          new)))))
(defn f'' [n]
  (println "run!")
  (* n 10))
(def fm'' (memoize'' f''))
(fm'' 2) ;; => 20 ;; run!
(fm'' 2) ;; => 20
(fm'' 2) ;; => 20
(fm'' 5) ;; => 50 ;; run!
(fm'' 6) ;; => 60 ;; run!
