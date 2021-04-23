(require '[manifold.deferred :as d])

(def abc (d/deferred))
;; => #'user/abc

abc
;; => #<Deferred@2b6c60d1: :not-delivered>

(d/success! abc :foo)
;; => true

abc
;; => #<Deferred@2b6c60d1: :foo>

@abc
;; => :foo


(defn my-inc [x]
  (inc x))


(d/future (my-inc))

(d/chain )

(dissoc {:a 1 :b 2 :c 3} :b :c)
