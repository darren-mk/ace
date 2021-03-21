;;https://www.4clojure.com/problem/107

;; pow
(Math/pow 7 2) ;; => 49.0
;; int
(int 3.3) ;; => 3
(int 4.9) ;; => 4
(int -0.8) ;; => 0
(int -1.1) ;; => -1

;; 1
(defn f1 [a]
  (fn [b] (int (Math/pow b a))))
(= 256 ((f1 2) 16) ((f1 8) 2)) ;; => true
(= [1 8 27 64] (map (f1 3) [1 2 3 4])) ;; => true
(= [1 2 4 8 16] (map #((f1 %) 2) [0 1 2 3 4])) ;; => true

;; 2
(defn f2 [x]
  (fn [y] (int (Math/pow y x))))
(= 256 ((f2 2) 16) ((f2 8) 2)) ;; => true 
(= [1 8 27 64] (map (f2 3) [1 2 3 4])) ;; => true
(= [1 2 4 8 16] (map #((f2 %) 2) [0 1 2 3 4])) ;; => true
