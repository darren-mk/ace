;; implementation of sum using reduce
(defn sum-using-reduce [coll]
  (reduce
   (fn [s v] (+ s v))
   0
   coll))
(sum-using-reduce [1 2 3]) ;; => 6
(sum-using-reduce []) ;; => 0
(sum-using-reduce nil) ;; => 0
(sum-using-reduce (range 100000)) ;; => 4999950000

;; implementation of sum using reduce-2
(defn sum-using-reduce-2 [coll]
  (reduce + 0 coll))
(sum-using-reduce-2 [1 2 3]) ;; => 6
(sum-using-reduce-2 []) ;; => 0
(sum-using-reduce-2 nil) ;; => 0
(sum-using-reduce-2 (range 100000)) ;; => 4999950000

;; implementation of sum using loop
(defn sum-using-loop [coll]
  (loop [s 0
         coll coll]
    (if (empty? coll)
      s
      (recur (+ s (first coll))
             (rest coll)))))
(sum-using-loop [1 2 3]) ;; => 6
(sum-using-loop []) ;; => 0
(sum-using-loop nil) ;; => 0
(sum-using-loop (range 100000)) ;; => 4999950000

;; implementation of sum using loop 2
(defn sum-using-loop-2 [coll]
  (loop [s 0
         [elem & more :as coll] coll]
    (if (empty? coll)
      s
      (recur (+ s elem) more))))
(sum-using-loop-2 [1 2 3]) ;; => 6
(sum-using-loop-2 []) ;; => 0
(sum-using-loop-2 nil) ;; => 0
(sum-using-loop-2 (range 100000)) ;; => 4999950000

;; implementation of sum using recursion
(defn sum-using-recursion [sum-so-far coll]
  (if (empty? coll)
    sum-so-far
    (recur
     (+ sum-so-far (first coll))
     (rest coll))))
(sum-using-recursion 0 [1 2 3])
(sum-using-recursion 0 []) ;; => 0
(sum-using-recursion 0 nil) ;; => 0
(sum-using-recursion 0 (range 100000))
;; => 4999950000

;; implementation of sum - 6
(defn sum-6 [coll]
  (apply + coll))
(sum-6 [1 2 3]) ;; => 6
(sum-6 []) ;; => 0
(sum-6 nil) ;; => 0
(sum-6 (range 100000)) ;; => 4999950000
