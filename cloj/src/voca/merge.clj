;; merge
(merge {:a 1 :b 3} {:b 9 :d 4}) ;; => {:a 1, :b 9, :d 4}

(defn merge-a [a b]
  (let [f (fn [m [k v]] (assoc m k v))]
    (reduce f a b)))
(merge-a {:a 1 :b 3} {:b 9 :d 4})
;; => {:a 1, :b 9, :d 4}
