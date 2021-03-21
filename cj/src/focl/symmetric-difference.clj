;; https://www.4clojure.com/problem/88

;; 1
(require '[clojure.set :refer [union difference]])
(defn f1 [a b]
  (union (difference a b) (difference b a)))
(= (f1 #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7}) ;; => true
(= (f1 #{:a :b :c} #{}) #{:a :b :c}) ;; => true
(= (f1 #{} #{4 5 6}) #{4 5 6}) ;; => true
(= (f1 #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]}) ;; => true

;; 2
(defn f2 [a b]
  (let [a-unique (filter #(not (contains? a %)) b)
        b-unique (filter #(not (contains? b %)) a)]
    (set (clojure.set/union a-unique b-unique))))
(= (f2 #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7}) ;; => true
(= (f2 #{:a :b :c} #{}) #{:a :b :c}) ;; => true
(= (f2 #{} #{4 5 6}) #{4 5 6}) ;; => true
(= (f2 #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]}) ;; => true

;; 3
(defn f3 [a b]
  (set 
   (union 
    (filter (complement a) b)
    (filter (complement b) a))))
(= (f3 #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7}) ;; => true
(= (f3 #{:a :b :c} #{}) #{:a :b :c}) ;; => true
(= (f3 #{} #{4 5 6}) #{4 5 6}) ;; => true
(= (f3 #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]}) ;; => true
