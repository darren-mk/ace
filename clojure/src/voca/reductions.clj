;; (reductions f coll)
;; (reductions f init coll)
;; Returns a lazy seq of the intermediate values
;; of the reduction (as per reduce) of coll by f,
;; starting with init.

(reductions + [1 2 3]) ;; => (1 3 6)
(reductions - [1 2 3]) ;; => (1 -1 -4)

(defn reductions'
  ([f col]
   (reductions' f col []))
  ([f col a]
   (let [af (fn [acc item]
              (conj acc (if (last acc)
                          (f (last acc) item) item)))]
     (seq (reduce af a col)))))
(reductions' + [1 2 3]) ;; => (1 3 6)
(reductions' - [1 2 3]) ;; => (1 -1 -4)
