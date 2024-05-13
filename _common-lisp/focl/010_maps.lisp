;; https://4clojure.oxal.org/#/problem/10



(equalp 3 3
 ((hash-map :a 10, :b 20, :c 30) :b)

	)

(map :a 1)

(make-hash :a 1 :b 2)

(= __ (:b {:a 10, :b 20, :c 30}))
