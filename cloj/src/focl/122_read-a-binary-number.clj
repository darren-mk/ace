;; https://4clojure.oxal.org/#/problem/122

;; 1
;; ref: https://gist.github.com/SegFaultAX/3607101
(defn f1 [s] (Integer/parseInt s 2))
(= 0 (f1 "0")) :=> true
(= 7 (f1 "111")) :=> true
(= 8 (f1 "1000")) :=> true
(= 9 (f1 "1001")) :=> true
(= 255 (f1 "11111111")) :=> true
(= 1365 (f1 "10101010101")) :=> true
(= 65535 (f1 "1111111111111111")) :=> true

;; 2
(defn f2 [s]
  (reduce (fn [v m] (+ v (* (first m) (second m))))
          0
          (partition
           2 
           (interleave
            (reverse (map #(Integer/parseInt %) 
                          (map str (char-array s))))
            (iterate #(* 2 %) 1)))))
(= 0 (f2 "0")) :=> true
(= 7 (f2 "111")) :=> true
(= 8 (f2 "1000")) :=> true
(= 9 (f2 "1001")) :=> true
(= 255 (f2 "11111111")) :=> true
(= 1365 (f2 "10101010101")) :=> true
(= 65535 (f2 "1111111111111111")) :=> true

;; 3
(defn f3 [s]
  (let [parse #(Integer/parseInt %)
        digits (->> s char-array (map str)
                    (map parse) reverse)
        powers (iterate (fn [x] (* x 2)) 1)]
    (apply + (map * digits powers))))
(= 0 (f3 "0")) :=> true
(= 7 (f3 "111")) :=> true
(= 8 (f3 "1000")) :=> true
(= 9 (f3 "1001")) :=> true
(= 255 (f3 "11111111")) :=> true
(= 1365 (f3 "10101010101")) :=> true
(= 65535 (f3 "1111111111111111")) :=> true
