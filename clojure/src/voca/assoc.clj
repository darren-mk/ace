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
(count t) ;; => 2
(:x t) ;; => 2
(:y t) ;; => 2


;;;; implementation

;; a
(defn assoc-vector-a [vec i new-v]
  (into []
        (map (fn [[k v]] (if (= k i) new-v v))
             (zipmap (range) vec))))
(defn assoc-map-a [m k v]
  (merge m {k v}))
(defn assoc-a [col k v]
  (if (vector? col)
    (assoc-vector-a col k v)
    (assoc-map-a col k v)))
(assoc-a nil :key1 4) ;; => {:key1 4}
(assoc-a [1 2 3] 0 100) ;; => [100 2 3]

;; b
(defn assoc-b [col k v]
  (let [m (if (map? col)
            col
            (zipmap (range) col))
        merged (merge m {k v})]
    (if (vector? col)
      (into [] (vals merged))
      merged)))
(assoc-b nil :key1 4) ;; => {:key1 4}
(assoc-b [1 2 3] 3 10) ;; => [1 2 3 10]
(assoc-b [1 2 3] 0 100) ;; => [100 2 3]

;; c
(defn assoc''' [m k v]
  (let [f (fn [[k' v']]
            (if (= k' k) {k v}
                {k' v'}))]
    (apply merge (map f (merge m {k nil})))))
(assoc''' {:a 1 :b 2} :b 3)
;; => {:a 1, :b 3}
(assoc''' {:a 1 :b 2} :c 4)
;; => {:a 1, :b 2, :c 4}

