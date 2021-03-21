;; https://www.4clojure.com/problem/34

;; 1
(defn f1 [beg end]
  (loop [n beg
         r []]
    (if (>= n end)
      r
      (recur
       (+ n 1)
       (conj r n)))))
(= (f1 1 4) '(1 2 3)) ;; => true
(= (f1 -2 2) '(-2 -1 0 1)) ;; => true
(= (f1 5 8) '(5 6 7)) ;; => true

;; 2
(defn f2 [a b]
  (take (- b a) (iterate inc a)))
(= (f2 1 4) '(1 2 3)) ;; => true
(= (f2 -2 2) '(-2 -1 0 1)) ;; => true
(= (f2 5 8) '(5 6 7)) ;; => true
