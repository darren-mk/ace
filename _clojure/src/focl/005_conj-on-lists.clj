;; https://4clojure.oxal.org/#/problem/5

;; 1
(def v1 '(1 2 3 4))
(= v1 (conj '(2 3 4) 1)) :=> true
(= v1 (conj '(3 4) 2 1)) :=> true
