;;;; variable

(def foo 1)
;; => #'user/foo

(with-redefs [foo 2] foo)
;; => 2

foo
;; => 1


;;;; function

(defn pro [x] (* x x))
;; => #'user/pro

(pro 2)
;; => 4

(with-redefs [pro (fn [x] (+ x 1))]
  (pro 2))
;; => 3

(pro 2)
;; => 4
