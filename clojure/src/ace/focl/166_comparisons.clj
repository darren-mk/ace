;; https://4clojure.oxal.org/#/problem/166

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
  (let [a-b (f a b)
        b-a (f b a)]
    (cond (and (false? a-b) (false? b-a)) :eq
          (true? a-b) :lt
          (true? b-a) :gt
          :else nil)))
(= :gt (f2 < 5 1)) ;; => true
(= :eq (f2 (fn [x y] (< (count x) (count y))) "pear" "plum")) ;; => true
(= :lt (f2 (fn [x y] (< (mod x 5) (mod y 5))) 21 3)) ;; => true
(= :gt (f2 > 0 2)) ;; => true







