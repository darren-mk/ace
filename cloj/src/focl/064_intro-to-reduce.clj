;; https://www.4clojure.com/problem/64

;; 1
(defn f1
  ([a b] (+ a b))
  ([a] 1)
  ([] 0))
(= 15 (reduce f1 [1 2 3 4 5])) ;; => true
(=  0 (reduce f1 [])) ;; => true
(=  6 (reduce f1 1 [2 ])) ;; => false
