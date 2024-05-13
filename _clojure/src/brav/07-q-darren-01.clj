;; pass a print statement in string
;; and evaluate it

(def s (str '(println 123)))
;; => #'user/s

s
;; => "(println 123)"

(eval (read-string s))
;; => nil
;; 123

(type (read-string s))
;; clojure.lang.PersistentList

(type (first (read-string s)))
;; clojure.lang.Symbol - the symbol println

;; (eval (read-string "(foo 432)"))

;; evaluater first checks out structure

;; evaluator sees a list

;; checks first symbol of list

;; if its a macro, it will macroexpand, not evaluate the rest before macroexpand

;; if its a function, it will recur with the sub forms

(type (read-string "3"))
;; java.lang.Long

;; be aware of read-eval
(binding [*read-eval* false]
  (read-string "#=(+ 2 3)"))

;; check out clojure.edn/read-string
