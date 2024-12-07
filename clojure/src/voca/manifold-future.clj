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
