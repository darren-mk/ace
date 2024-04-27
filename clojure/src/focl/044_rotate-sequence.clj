;; https://4clojure.oxal.org/#/problem/44

;; a
(defn abs [n] (if (pos? n) n (* n -1)))
(defn f-a [n coll]
  (let [cnt (count coll)]
    (->> coll
         repeat
         (apply concat)
         (drop (if (pos? n) n (- cnt (rem (abs n) cnt))))
         (take cnt))))
(= (f-a 2 [1 2 3 4 5]) '(3 4 5 1 2)) ;; => true
(= (f-a -2 [1 2 3 4 5]) '(4 5 1 2 3)) ;; => true
(= (f-a 6 [1 2 3 4 5]) '(2 3 4 5 1)) ;; => true
(= (f-a 1 '(:a :b :c)) '(:b :c :a)) ;; => true
(= (f-a -4 '(:a :b :c)) '(:c :a :b)) ;; => true

;; b
(defn f-b [n coll]
  (->> (cycle coll)
       (take (+ n (count coll)))
       (drop n)))
(= (f-b 2 [1 2 3 4 5]) '(3 4 5 1 2)) ;; => true
(= (f-b -2 [1 2 3 4 5]) '(4 5 1 2 3)) 
(= (f-b 6 [1 2 3 4 5]) '(2 3 4 5 1)) ;; => true
(= (f-b 1 '(:a :b :c)) '(:b :c :a)) ;; => true
(= (f-b -4 '(:a :b :c)) '(:c :a :b))
