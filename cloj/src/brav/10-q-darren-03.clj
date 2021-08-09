;; create a dynamic var for your address
;; and change it temporarily to print

(def ^:dynamic *address* "NJ")
;; => #'user/*address*

(binding [*address* "NY"]
  (println *address*))
;; => nil
;; NY


;; NOTE: This binding is thread local
(binding [*address* "NY"]
  ;; just a Java thread, Clojure doesn't interfere
  (.start
   (Thread. (fn []
              (println *address*)))))
;; prints NJ, because binding is thread local

(binding [*address* "NY"]
  (let [f (future
            (println *address*))]
    @f
    ))
;; prints NY, because current bindings are carried over by Clojure


;; similar core.async/thread macro, will also copy over bindingso
;; (clojure.core.async/thread)
