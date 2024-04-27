(comment
  (new java.util.Random)
  "is equivelent to "
  (java.util.Random.))


;;;; random

(def r (new java.util.Random))
;; => #'user/r

r
;; => #object[java.util.Random 0x4de73aaf "java.util.Random@4de73aaf"]

(. r nextInt)
;; => 2031974597

(. r nextInt 10)
;; => 2


;;;; point

(def p (java.awt.Point. 10 20))
;; => #'user/p

(. p -x)
;; => 10

(. p -y)
;; => 20

(. Math -PI)
;; => 3.141592653589793
