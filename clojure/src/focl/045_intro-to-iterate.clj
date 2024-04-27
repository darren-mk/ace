;; https://4clojure.oxal.org/#/problem/45

;; trial 1
(= '(1 4 7 10 13) (take 5 (iterate #(+ 3 %) 1)))
;; => true
