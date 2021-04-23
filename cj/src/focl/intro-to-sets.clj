;; https://www.4clojure.com/problem/8

;; 1
(def v1 #{:a :b :c :d})
(= v1 (set '(:a :a :b :c :c :c :c :d :d)))
;; => true
(= v1 (clojure.set/union #{:a :b :c} #{:b :c :d}))
;; => true
