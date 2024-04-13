;; https://4clojure.oxal.org/#/problem/51

(def v1 [1 2 3 4 5])
(= [1 2 [3 4 5] [1 2 3 4 5]]
   (let [[a b & c :as d] v1] [a b c d]))
:=> true
