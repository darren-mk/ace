;; https://4clojure.oxal.org/#/problem/57

(def v1 '(5 4 3 2 1))
(= v1 ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))
:=> true
