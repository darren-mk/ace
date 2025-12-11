;; https://4clojure.oxal.org/#/problem/107

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

;; 3
(defn pow
  ([a]
   (* a a))
  ([a b]
   (pow a b 1))
  ([a b result]
   (if (<= b 0)
     result
     (pow a (dec b) (* a result)))))
(defn f3 [x]
  (fn [y] (pow y x)))
(= 256 ((f3 2) 16) ((f3 8) 2)) ;; => true 
(= [1 8 27 64] (map (f3 3) [1 2 3 4])) ;; => true
(= [1 2 4 8 16] (map #((f3 %) 2) [0 1 2 3 4])) ;; => true
