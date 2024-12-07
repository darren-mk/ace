;; clojure.core/hash-map
;; ([] [& keyvals])
;; keyval => key val
;; Returns a new hash map with supplied mappings.  If any keys are
;; equal, they are handled as if by repeated uses of assoc.

(hash-map 1 2 3 4)
;; => {1 2, 3 4}

(hash-map 1 2 1 3)
;; => {1 3}

;; implementation 1
(defn hash-map-alt-1 [& kvs]
  (if (empty? kvs)
    nil 
    (let [k (first kvs)
          v (second kvs)
          next (-> kvs rest rest)]
      (merge {k v}
             (apply hash-map-alt-1 next)))))
;; Leon, i can't use recur because of apply
;; the way i do here is considered right?
;; => #'user/hash-map-alt-1
(hash-map-alt-1 1 2 3 4)
;; => {1 2, 3 4}
