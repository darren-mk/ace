;; https://www.4clojure.com/problem/173

;; 1
(= 3
  (let [[f v] [+ (range 3)]] (apply f v))
  (let [[[f v] b] [[+ 1] 2]] (f v b))
  (let [[f v] [inc 2]] (f v))) ;; => true
