;; https://4clojure.oxal.org/#/problem/85

;; 1
;; https://4clojure.oxal.org/#/problem/85/solutions
(defn f1 [c]
  (reduce
   (fn [a b]
     (into a (for [x a]
               (do 
                 (prn "x is" x)
                 (prn "b is " b)
                 (conj x b)))))
   #{#{}}
   c))
(= (f1 #{1 :a}) #{#{1 :a} #{:a} #{} #{1}}) ;; => true
(= (f1 #{}) #{#{}}) ;; => true
(= (f1 #{1 2 3})
   #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}}) ;; => true
(= (count (f1 (into #{} (range 10)))) 1024) ;; => true

;; 2
;; https://4clojure.oxal.org/#/problem/85/solutions
(defn f2 [s]
  (if (empty? s)
    #{#{}}
    (let [head (first s)
          tail-p (f2 (rest s))]
      (into tail-p (map #(conj % head) tail-p)))))
(= (f2 #{1 :a}) #{#{1 :a} #{:a} #{} #{1}}) ;; => true
(= (f2 #{}) #{#{}}) ;; => true
(= (f2 #{1 2 3})
   #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}}) ;; => true
(= (count (f2 (into #{} (range 10)))) 1024) ;; => true
