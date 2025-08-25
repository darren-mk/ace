(ns voca.when-not)

(defmacro when-not-a [b & body]
  (list 'if (list 'not b) (cons 'do body) nil))

(macroexpand '(when-not-a false 1))
;; => (if (not false) (do 1) nil)
(when-not-a true 1) ;; => nil
(when-not-a false 1) ;; => 1


(defmacro when-not-b [b & body]
  `(if (not ~b) (do ~@body) nil))

(macroexpand '(when-not-b false 1))
;; => (if (clojure.core/not false) (do 1) nil)
(macroexpand '(when-not-b (< 2 3) 1))
;; => (if (clojure.core/not (< 2 3)) (do 1) nil)
(when-not-b true 1) ;; => nil
(when-not-b false 1) ;; => 1
