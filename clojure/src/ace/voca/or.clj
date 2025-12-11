(ns voca.or)

(defmacro or-a
  ([] nil)
  ([x] x)
  ([x & xs]
   `(if ~x ~x (or-a ~@xs))))

(or-a 1 nil 2) ;; => 1
(or-a nil) ;; => nil
(or-a 1 2) ;; => 1
(macroexpand '(or-a 1 nil 2))
;; => (if 1 1 (voca.or/or-a nil 2))
