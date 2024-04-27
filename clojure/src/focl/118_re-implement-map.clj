;; https://4clojure.oxal.org/#/problem/118

;; 1
(defn f1 [f coll]
  (for [x coll]
    (f x)))
(= [3 4 5 6 7]
   (f1 inc [2 3 4 5 6])) ;; => true
(= (repeat 10 nil)
   (f1 (fn [_] nil) (range 10))) ;; => true
(= [1000000 1000001]
   (->> (f1 inc (range))
        (drop (dec 1000000))
        (take 2))) ;; => true

;; 2
(defn f2 [f coll]
  (if (empty? coll)
    '()
    (cons 
     (f (first coll))
     (f2 f (rest coll)))))
(= [3 4 5 6 7]
   (f2 inc [2 3 4 5 6])) ;; => true 
(= (repeat 10 nil)
   (f2 (fn [_] nil) (range 10))) ;; => true
(= [1000000 1000001]
   (->> (f2 inc (range))
        (drop (dec 1000000))
        (take 2))) ;; stackoverflow 

;; 3
(defn f3 [f l]
  (if (empty? l)
    []
    (lazy-seq
     (cons (f (first l))
           (f3 f (rest l))))))
(= [3 4 5 6 7]
   (f3 inc [2 3 4 5 6])) ;; => true 
(= (repeat 10 nil)
   (f3 (fn [_] nil) (range 10))) ;; => true
(= [1000000 1000001]
   (->> (f3 inc (range))
        (drop (dec 1000000))
        (take 2))) ;; => true
