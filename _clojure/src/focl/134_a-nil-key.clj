;; https://4clojure.oxal.org/#/problem/134

;; a
(def f-a
  (fn [k m]
    (if (contains? m k)
      (nil? (k m))
      false)))
(true? (f-a :a {:a nil :b 2})) ;; => true
(false? (f-a :b {:a nil :b 2})) ;; => true
(false? (f-a :c {:a nil :b 2})) ;; => true

;; b
(defn f-b [x m]
  (and (contains? m x)
       (nil? (get m x))))
(true? (f-b :a {:a nil :b 2})) ;; => true
(false? (f-b :b {:a nil :b 2})) ;; => true
(false? (f-b :c {:a nil :b 2})) ;; => true

;; c
(defn f-c [x m]
  (cond (not (contains? m x)) false
        (x m) false 
        :else true))
(true? (f-c :a {:a nil :b 2})) ;; => true
(false? (f-c :b {:a nil :b 2})) ;; => true
(false? (f-c :c {:a nil :b 2})) ;; => true
