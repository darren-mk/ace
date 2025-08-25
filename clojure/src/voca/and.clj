(ns voca.and)

(and 1 nil)

(defmacro and-a
  ([] true)
  ([x] x)
  ([x & xs]
   `(if ~x (and-a ~@xs) ~x)))

(and-a 1 nil) ;; => nil
(and-a 1 2) ;; => 2
(macroexpand '(and-a 1 nil))
;; => (if 1 (voca.and/and-a nil) 1)
