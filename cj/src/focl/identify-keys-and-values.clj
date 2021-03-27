;; https://www.4clojure.com/problem/105

;; 1
(defn f1 [vec]
  (reduce
   (fn [m v]
     (if (keyword? v)
       (assoc m v [])
       (update m (-> m last first) #(conj % v))))
   (sorted-map)
   vec))
(= {} (f1 [])) ;; => true
(= {:a [1]} (f1 [:a 1])) ;; => true
(= {:a [1], :b [2]} (f1 [:a 1, :b 2])) ;; => true
(= {:a [1 2 3], :b [], :c [4]} (f1 [:a 1 2 3 :b :c 4])) ;; => true
