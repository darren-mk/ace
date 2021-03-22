;; https://leetcode.com/problems/reverse-integer/

;; 1
(defn f1 [x]
  (let [sign
        (fn [n]
          (* n (if (neg? x)
                 -1
                 1)))]
    (->> x
         Math/abs
         str
         reverse
         (apply str)
         Integer/parseInt
         sign)))
(= 321 (f1 123)) ;; => true
(= -321 (f1 -123)) ;; => true
(= 21 (f1 120)) ;; => true
(= 0 (f1 0)) ;; => true
