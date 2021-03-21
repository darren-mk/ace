;; https://www.4clojure.com/problem/120

;; trial 1
(str 15) ;; => "15"
(clojure.string/split "15" #"") ;; => ["1" "5"]
(map #(-> % Integer/parseInt) ["1" "5"]) ;; => (1 5)
(map #(* % %) [1 5]) ;; => (1 25)
(reduce + [1 25]) ;; => 26
(< 15 26) ;; => true

;; 1
(defn smaller-than-squared-components?  [n]
  (as-> n v
       (str v)
       (clojure.string/split v #"")
       (map #(Integer/parseInt %) v)
       (map #(* % %) v)
       (reduce + v)
       (< n v)))
(defn f1 [coll]
  (as-> coll v
    (map smaller-than-squared-components? v)
    (map #(if % 1 0) v)
    (reduce + v)))
(= 8 (f1 (range 10))) ;; => true
(= 19 (f1 (range 30))) ;; => true
(= 50 (f1 (range 100))) ;; => true
(= 50 (f1 (range 1000))) ;; => true











;; 2



(= 8 (f2 (range 10))) 
(= 19 (f2 (range 30))) 
(= 50 (f2 (range 100))) 
(= 50 (f2 (range 1000))) 
