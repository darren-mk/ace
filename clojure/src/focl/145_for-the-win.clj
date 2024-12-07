;; https://4clojure.oxal.org/#/problem/145

;; 1
(def v1
  (list 1 5 9 13 17 21 25 29 33 37))
(= v1 (for [x (range 40)
            :when (= 1 (rem x 4))]
        x)) ;; => true
(= v1 (for [x (iterate #(+ 4 %) 0)
            :let [z (inc x)]
            :while (< z 40)]
        z)) ;; => true
(= v1 (for [[x y] (partition 2 (range 20))]
        (+ x y))) ;; => true
