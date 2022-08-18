;; https://www.4clojure.com/problem/51

;; 1
(= [1 2 [3 4 5] [1 2 3 4 5]]
   (let [[a b & c :as d] [1 2 3 4 5]] [a b c d])) ;; => true

;; 2
(= [1 2 [3 4 5] [1 2 3 4 5]]
   (let [[a b & c :as d] (range 1 6)] [a b c d])) ;; => true

;; 3
(def v3 [1 2 3 4 5])
(= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] v3] [a b c d]))
