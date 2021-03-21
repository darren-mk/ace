;; https://www.4clojure.com/problem/62

;; 1
(defn f1 [f n]
  (lazy-seq (cons n (f1 f (f n)))))
(= (take 5 (f1 #(* 2 %) 1)) [1 2 4 8 16]) ;; => true
(= (take 100 (f1 inc 0)) (take 100 (range))) ;; => true
(= (take 9 (f1 #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3]))) ;; => true
