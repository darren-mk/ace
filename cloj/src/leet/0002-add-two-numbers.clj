;; https://leetcode.com/problems/add-two-numbers/

;; 1
(defn f1 [l1 l2]
  (let [process (fn [l]
                  (reduce +
                          0
                          (map * (reverse l)
                               (iterate #(* 10 %) 1))))
        a (process l1) 
        b (process l2)
        c (->> (+ a b)
               str
               reverse
               (map str)
               (map #(Integer/parseInt %)))]
    c))
(= [7 0 8] (f1 [2 4 3] [5 6 4])) ;; => true
(= [0] (f1 [0] [0])) ;; => true
(= [8 9 9 9 0 0 0 1] (f1 [9 9 9 9 9 9 9] [9 9 9 9])) ;; => true

;; 2
(defn zip-it [l]
  (apply +
         (map #(* %1 %2)
              l
              (map #(Math/pow 10 %) (range)))))
(defn unzip-it [n]
  (->> n
       str
       reverse
       (map #(Integer. (str %)))))
(defn f2 [l1 l2]
  (unzip-it
   (apply +
          (map #(-> % zip-it int) [l1 l2]))))
(f2 [2 4 3] [5 6 4])
(f2 [9 9 9 9 9 9 9] [9 9 9 9])
