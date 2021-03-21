;; https://www.4clojure.com/problem/46

;; trial 1
(defn f1 [f]
  (fn [a b] (f b a)))
(= 3 ((f1 nth) 2 [1 2 3 4 5])) ;; => true
(= true ((f1 >) 7 8)) ;; => true
(= 4 ((f1 quot) 2 8)) ;; => true
(= [1 2 3] ((f1 take) [1 2 3 4 5] 3)) ;; => true
