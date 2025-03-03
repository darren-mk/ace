(def tr
  (transient {:a 1 :b 2}))
;; => #'user/tr

tr
;; => #object[clojure.lang.PersistentArrayMap$TransientArrayMap 0x38187248 "clojure.lang.PersistentArrayMap$TransientArrayMap@38187248"]

(dissoc! tr :b)
;; => #object[clojure.lang.PersistentArrayMap$TransientArrayMap 0x300fd9b1 "clojure.lang.PersistentArrayMap$TransientArrayMap@300fd9b1"]

(assoc! tr :c 3)
;; => #object[clojure.lang.PersistentArrayMap$TransientArrayMap 0x300fd9b1 "clojure.lang.PersistentArrayMap$TransientArrayMap@300fd9b1"]

(persistent! tr)
;; => {:a 1, :c 3}
