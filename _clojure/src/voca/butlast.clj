(butlast [1 2 3 4]) ;; => (1 2 3)
(butlast '(:a "x" 123)) ;; => (:a "x")

;;;; implementation

;; a
(defn butlast-a [coll]
  (vals
   (filter #(not= (dec (count coll)) (key %))
           (zipmap (range) coll))))
(butlast-a [1 2 3 4]) ;; => (1 2 3)
(butlast-a '(:a "x" 123)) ;; => (:a "x")

;; b
(defn butlast-b [coll]
  (if (= 1 (count coll))
    nil
    (cons (first coll) (butlast-b (rest coll)))))
(butlast-b [1 2 3 4]) ;; => (1 2 3)
(butlast-b (list :a "x" 123)) ;; => (:a "x")
