(def ^:dynamic x 1)
;; => #'user/x

(binding [x 100]
  (+ x x))
;; => 200

x
;; => 1

(def ^:dynamic y 2)

(binding [y 3]
  (* y y))
;; => 9

(* y y)
;; => 4
