;; https://www.4clojure.com/problem/161

;; 1
(def v1 #{1 2})
(clojure.set/superset? v1 #{2}) ;; => true
(clojure.set/subset? #{1} v1) ;; => true
(clojure.set/superset? v1 #{1 2}) ;; => true
(clojure.set/subset? #{1 2} v1) ;; => true
