(read-string "123")
;; => 123

(read-string "abc")
;; => abc

(type (read-string "abc"))
;; => clojure.lang.Symbol

(read-string "129834710892374102839471028394723424234")
;; => 129834710892374102839471028394723424234N

(type (read-string "129834710892374102839471028394723424234"))
;; => clojure.lang.BigInt
;; works with biginteger
;; while below doesn't work
;; (Integer/parseInt "129834710892374102839471028394723424234")
;; fails

(read-string "(+ 1 2)")
;; => (+ 1 2)

(type (read-string "(+ 1 2)"))
;; => clojure.lang.PersistentList

(eval (read-string "(+ 1 2)"))
;; => 3

(list + 1 2)
;; => (#function[clojure.core/+] 1 2)

'(+ 1 2)
;; => (+ 1 2)
