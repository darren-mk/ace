;; https://4clojure.oxal.org/#/problem/171

;; 1
(defn f1 [l]
  (loop [archive []
         current []
         sl (sort (distinct l))]
    (cond (and (empty? sl) (empty? archive) (empty? current))
          []
          (empty? sl)
          (->> (conj archive current)
               (map (fn [vec] (vector (first vec) (last vec))))
               distinct)
          (empty? current)
          (recur archive (conj current (first sl)) (rest sl))
          (= (inc (last current)) (first sl))
          (recur archive (conj current (first sl)) (rest sl))
          :else
          (recur (conj archive current) (vector (first sl)) (rest sl)))))
(= (f1 [1 2 3]) [[1 3]]) ;; => true
(= (f1 [10 9 8 1 2 3]) [[1 3] [8 10]]) ;; => true
(= (f1 [1 1 1 1 1 1 1]) [[1 1]]) ;; => true
(= (f1 []) []) ;; => true
(= (f1 [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11])
   [[1 4] [6 6] [9 11] [13 17] [19 19]]) ;; => true
