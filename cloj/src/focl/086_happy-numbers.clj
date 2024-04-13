;; https://4clojure.oxal.org/#/problem/86

(require '[clojure.string :as cstr])

(defn f1 [n])
(= (f1 7) true)
(= (f1 986543210) true)
(= (f1 2) false)
(= (f1 3) false)
