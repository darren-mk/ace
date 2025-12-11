(get {:a 1 :b 2} :a) ;; => 1
(:a {:a 1 :b 2}) ;; => 1
(:c {:a 1 :b 2} "can't find") ;; => "can't find"
({:a 1 :b 2} :a) ;; => 1
(get [3 2 1] 0) ;; => 3
(get '(3 2 1) 0) ;; => nil
(nth [3 2 1] 0) ;; => 3
(nth '(3 2 1) 0) ;; => 3
(get #{:a :b} :a) ;; => :a
(contains? #{:a :b} :a) ;; => true

(defn get' [[p & _ :as m] x]
  (if (sequential? m)
    (recur (zipmap (range) m) x)
    (when p
      (if (= x (key p)) (val p)
          (recur (dissoc m (key p)) x)))))
(get' {:a 1 :b 2 :c 3} :c) ;; => 3
(get' '(3 2 1) 1) ;; => 2
(get' [1 2 3] 0) ;; => 1
