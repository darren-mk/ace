(class "abc")
;; => java.lang.String

(type "abc")
;; => java.lang.String

(= (class "a") (type "a"))
;; => true

(class +)
;; => clojure.core$_PLUS_

(type +)
;; => clojure.core$_PLUS_

(= (class +) (type +))
;; => true

;; how is class different from type?
