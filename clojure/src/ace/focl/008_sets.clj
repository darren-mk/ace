;; https://4clojure.oxal.org/#/problem/8

(require '[clojure.set :as cset])

;; 1
(def v1 #{:a :b :c :d})
(= v1 (set '(:a :a :b :c :c :c :c :d :d)))
:=> true
(= v1 (cset/union #{:a :b :c} #{:b :c :d}))
:=> true
