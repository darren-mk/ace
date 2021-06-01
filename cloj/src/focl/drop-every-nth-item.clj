;; https://www.4clojure.com/problem/41

;; 1
(defn f1 [coll n]
  (mapcat
   identity
   (partition-all (dec n) n coll)))
(= (f1 [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]);; => true
(= (f1 [:a :b :c :d :e :f] 2) [:a :c :e]) ;; => true
(= (f1 [1 2 3 4 5 6] 4) [1 2 3 5 6]) ;; => true

;; 2
(select-keys 
 (zipmap (iterate inc 1)
         [1 2 3 4 5 6 7 8])
 ;; => {1 1, 2 2, 3 3, 4 4, 5 5, 6 6, 7 7, 8 8}
 (take (count [1 2 3 4 5 6 7 8]) 
       (filter #(not= 0 (mod % 3)) (iterate inc 1))))
;; => {1 1, 2 2, 4 4, 5 5, 7 7, 8 8}
(defn f2 [coll n]
  (let [tagged (zipmap (iterate inc 1) coll)
        target (take (count coll)
                     (filter #(not= 0 (mod % n)) (iterate inc 1) )
                     )]
    (vals (select-keys tagged target))))
(= (f2 [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]) ;; => true
(= (f2 [:a :b :c :d :e :f] 2) [:a :c :e]) ;; => true
(= (f2 [1 2 3 4 5 6] 4) [1 2 3 5 6]) ;; => true
