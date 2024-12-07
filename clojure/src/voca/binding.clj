(def ^:dynamic x 1)
;; => #'user/x

(binding [x 100]
  (+ x x))
;; => 200

x
;; => 1
