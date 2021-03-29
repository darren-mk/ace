;; https://www.4clojure.com/problem/21

;; 1
(defn f1 [coll index]
  (loop [c coll i 0]
    (if (>= i index)
      (first c)
      (recur (rest c) (+ i 1)))))
(= (f1 '(4 5 6 7) 2) 6) ;; => true
(= (f1 [:a :b :c] 0) :a) ;; => true
(= (f1 [1 2 3 4] 1) 2) ;; => true
(= (f1 '([1 2] [3 4] [5 6]) 2) [5 6]) ;; => true

;; 2
(defn f2 [coll index]
  (get
   (into
    {} (map-indexed hash-map coll))
   index))
(= (f2 '(4 5 6 7) 2) 6) ;; => true
(= (f2 [:a :b :c] 0) :a) ;; => true
(= (f2 [1 2 3 4] 1) 2) ;; => true
(= (f2 '([1 2] [3 4] [5 6]) 2) [5 6]) ;; => true

;; 3
(defn f3 [coll index]
  (as-> coll c
    (zipmap (iterate inc 0) c)
    (get c index)))
(= (f3 '(4 5 6 7) 2) 6) ;; => true
(= (f3 [:a :b :c] 0) :a) ;; => true
(= (f3 [1 2 3 4] 1) 2) ;; => true
(= (f3 '([1 2] [3 4] [5 6]) 2) [5 6]) ;; => true

;; 4
(defn f4 [coll index]
  (get (vec coll) index))
(= (f4 '(4 5 6 7) 2) 6) ;; => true
(= (f4 [:a :b :c] 0) :a) ;; => true 
(= (f4 [1 2 3 4] 1) 2) ;; => true 
(= (f4 '([1 2] [3 4] [5 6]) 2) [5 6]) ;; => true

;; 5
(defn f5 [coll index]
  (key 
   (first 
    (filter
     (fn [item] (= (val item) index))
     (zipmap coll (iterate inc 0))))))
(= (f5 '(4 5 6 7) 2) 6) ;; => true
(= (f5 [:a :b :c] 0) :a) ;; => true 
(= (f5 [1 2 3 4] 1) 2) ;; => true 
(= (f5 '([1 2] [3 4] [5 6]) 2) [5 6]) ;; => true

;; 6
(defn f6 [coll index]
  (->> coll
       (zipmap (iterate inc 0))
       (filter #(= (key %) index))
       first
       val))
(= (f6 '(4 5 6 7) 2) 6) ;; => true
(= (f6 [:a :b :c] 0) :a) ;; => true 
(= (f6 [1 2 3 4] 1) 2) ;; => true 
(= (f6 '([1 2] [3 4] [5 6]) 2) [5 6]) ;; => true
