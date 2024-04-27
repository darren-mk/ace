;; https://4clojure.oxal.org/#/problem/161

(require '[clojure.set :refer [superset? subset?]])

;; 1
(def v1 #{1 2})
(superset? v1 #{2}) ;; => true
(subset? #{1} v1) ;; => true
(superset? v1 #{1 2}) ;; => true
(subset? #{1 2} v1) ;; => true
