;; https://4clojure.oxal.org/#/problem/9

;; 1
(def v1 2)
(= #{1 2 3 4} (conj #{1 4 3} v1))
:=> true

