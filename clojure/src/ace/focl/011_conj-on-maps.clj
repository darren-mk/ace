;; https://www.4clojure.com/problem/11

;; When operating on a map, the conj function returns a new map
;; with one or more key-value pairs "added".

;; 1
(def v1 {:b 2})
(= {:a 1, :b 2, :c 3} (conj {:a 1} v1 [:c 3])) ;; => true
