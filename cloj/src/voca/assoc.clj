;;;; asoc

(assoc {} :key1 "v" :key2 "another")
;; => {:key1 "v", :key2 "another"}

(assoc nil :key1 4)
;; => {:key1 4}

(assoc [1 2 3] 3 10)
;; => [1 2 3 10]

(assoc [1 2 3] 0 100)
;; => [100 2 3]


;;;; assoc!
(def t (transient {:x 1}))
;; => #'focl.core/t

(assoc! t :x 2 :y 2)
;; => #object[clojure.lang.PersistentArrayMap$TransientArrayMap 0x4683b262 "clojure.lang.PersistentArrayMap$TransientArrayMap@4683b262"]

t
;; => #object[clojure.lang.PersistentArrayMap$TransientArrayMap 0x4683b262 "clojure.lang.PersistentArrayMap$TransientArrayMap@4683b262"]

(count t)
;; => 2

(:x t)
;; => 2

(:y t)
;; => 2
