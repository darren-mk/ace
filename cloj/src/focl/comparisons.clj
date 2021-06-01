;; https://www.4clojure.com/problem/166

;; 1
(defn f1 [f a b]
  (cond
    (f a b) :lt
    (f b a) :gt
    :else :eq))
(= :gt (f1 < 5 1)) ;; => true
(= :eq (f1 (fn [x y] (< (count x) (count y))) "pear" "plum")) ;; => true
(= :lt (f1 (fn [x y] (< (mod x 5) (mod y 5))) 21 3)) ;; => true
(= :gt (f1 > 0 2)) ;; => true



;; 2
(defn f2 [f a b]
  (case (f a b)

    
  


      )
  
  


  )


(= :gt (f2 < 5 1)) ;; => true
(= :eq (f2 (fn [x y] (< (count x) (count y))) "pear" "plum")) ;; => true
(= :lt (f2 (fn [x y] (< (mod x 5) (mod y 5))) 21 3)) ;; => true
(= :gt (f2 > 0 2)) ;; => true







