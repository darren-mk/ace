;; clojure.core/merge-with
;; ([f & maps])
;; Returns a map that consists of the rest of the maps conj-ed onto
;; the first.  If a key occurs in more than one map, the mapping(s)
;; from the latter (left-to-right) will be combined with the mapping in
;; the result by calling (f val-in-result val-in-latter).

(merge-with +
            {:a 1 :b 2}
            {:a 5 :b 2 :c 1})
;; => {:a 6, :b 4, :c 1}

(merge-with -
            {:a 1 :b 2}
            {:a 5 :b 2 :c 1})
;; => {:a -4, :b 0, :c 1}

(defn merge-with'
  ([f m1 m2]
   (merge-with' f m1 m2 (keys (merge m1 m2)) {}))
  ([f m1 m2 [k & ks :as aks] acc]
   (if (empty? aks) acc
       (merge-with'
        f m1 m2 ks
        (assoc acc k (apply f (remove nil? [(get m1 k) (get m2 k)])))))))
(merge-with' + {:a 1 :b 2} {:a 5 :b 2 :c 1})
;; => {:a 6, :b 4, :c 1}
(merge-with' - {:a 1 :b 2} {:a 5 :b 2 :c 1})
;; => {:a -4, :b 0, :c -1}
