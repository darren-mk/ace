;; clojure.core/declare
;; ([& names])
;; Macro
;; defs the supplied var names with no bindings, useful for making forward declarations.

(declare middle-name)
;; => #'user/middle-name
middle-name
;; => #object[clojure.lang.Var$Unbound 0x3a7be687 "Unbound: #'user/middle-name"]
(defn middle-name [] "minsoo")
;; => #'user/middle-name
(def full-name
  ["darren" (middle-name) "kim"])
;; => #'user/full-name
full-name
;; => ["darren" "minsoo" "kim"]
