;; https://4clojure.oxal.org/#/problem/36

(= 10 (let [x 7 y 3] (+ x y))) ;; true
(= 4 (let [y 3 z 1] (+ y z))) ;; true
(= 1 (let [z 1] z)) ;; true
