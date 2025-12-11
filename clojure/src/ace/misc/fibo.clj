;; 1
(def c (atom 0))
(defn fib-1 [n]
  (let [bn (bigint n)]
    (swap! c inc)
    (case bn
      0N 0N
      1N 1N
      (+ (fib-1 (- bn 1N))
         (fib-1 (- bn 2N))))))
@c ;; => 0
(fib-1 30) ;; => 832040N
@c ;; => 2692537
(time (fib-1 10))
(time (fib-1 20))
(time (fib-1 40))
;; "Elapsed time: 10999.311614 msecs"
;; not optimized

;; 2
(def memo
  (atom {0N 0N
         1N 1N}))
(defn fib-2 [n]
  (let [bn (bigint n)]
    (if (contains? @memo bn)
      (get @memo bn)
      (let [calcd (+ (fib-2 (- bn 1N))
                     (fib-2 (- bn 2N)))]
        (swap! memo (fn [m] (assoc m n calcd)))
        calcd))))
(time (fib-2 10000))
;; "Elapsed time: 2.530179 msecs"

;; 3 
;; greg's implementation, tail-call optimized
(defn fib-3
  ([n]
   (fib-3 n 0N 1N))
  ([n a b]
   (if (= n 0)
     a
     (recur (- n 1) b (+ a b)))))
(time (fib-3 10000))
;; "Elapsed time: 11.51101 msecs"
(time (fib-3 100000))
;; "Elapsed time: 167.986037 msecs"
;; well-optimized
