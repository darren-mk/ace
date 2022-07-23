;; https://www.geeksforgeeks.org/linear-search/

(defn linear-search [l x]
  (loop [i 0]
    (cond (<= (count l) i) -1
          (= x (get l i)) i
          :else (recur (inc i)))))
(linear-search [10 20 80 30 60 50 110 100 130 170] 110) ;; => 6
(linear-search [10 20 80 30 60 50 110 100 130 170] 175) ;; => -1


;; https://www.geeksforgeeks.org/binary-search/

(defn binary-search [l x]
  (if (vector? l)
    (binary-search (zipmap (range) l) x)
    (let [mid (+ (-> l first key) (/ (count l) 2))
          a (filter #(< (key %) mid) l)
          b (filter #(>= (key %) mid) l)]
      (cond (or (empty? a) (empty? b)) -1
            (= x (val (last a))) (key (last a))
            (< x (val (last a))) (binary-search a x)
            :else (binary-search b x)))))
(binary-search [2 3 4 10 40] 10) ;; => 3


;; https://www.geeksforgeeks.org/jump-search/

(defn jump-search [l x]
  (let [step (-> l count Math/sqrt int)]
    (loop [i 0]
      (cond (= x (get l i)) i
            (< x (get l i)) (recur (dec i))
            (> x (get l i)) (recur (+ i step))))))
(jump-search [0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610] 55)
;; => 10

;; https://www.geeksforgeeks.org/interpolation-search/

;; skipped


