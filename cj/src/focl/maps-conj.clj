;; https://www.4clojure.com/problem/11

;; 1
(def v1 {:b 2})
(= {:a 1, :b 2, :c 3} (conj {:a 1} v1 [:c 3])) ;; => true
