;; https://www.4clojure.com/problem/16

;; 1
(defn f1 [s]
  (str "Hello, " s "!"))
(= (f1 "Dave") "Hello, Dave!") ;; => true
(= (f1 "Jenn") "Hello, Jenn!") ;; => true
(= (f1 "Rhea") "Hello, Rhea!") ;; => true
