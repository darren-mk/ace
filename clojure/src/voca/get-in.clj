;; get-in
(get-in {:a 0 :b {:c "ho hum"}} [:b :c]) ;; => "ho hum"

(defn get-in'
  [m [k & ks]]
  (if k (recur (get m k) ks) m))
(get-in' {:a 0 :b {:c "ho hum"}} [:a]) ;; => 0
(get-in' {:a 0 :b {:c "ho hum"}} [:b :c]) ;; => "ho hum"

