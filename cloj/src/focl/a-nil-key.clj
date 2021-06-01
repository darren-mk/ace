;; https://www.4clojure.com/problem/134

;; 1
(def f1
  (fn [k m]
    (if (contains? m k)
      (nil? (k m))
      false)))
(true? (f1 :a {:a nil :b 2})) ;; => true
(false? (f1 :b {:a nil :b 2})) ;; => true
(false? (f1 :c {:a nil :b 2})) ;; => true

;; 2
(defn f2 [x m]
  (and (contains? m x)
       (nil? (get m x))))
(true? (f2 :a {:a nil :b 2})) ;; => true
(false? (f2 :b {:a nil :b 2})) ;; => true
(false? (f2 :c {:a nil :b 2})) ;; => true
