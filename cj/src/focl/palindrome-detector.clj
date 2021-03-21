;; https://www.4clojure.com/problem/27

;; 1
(defn f1 [seq]
  (let [r (if (string? seq)
            (clojure.string/join (reverse seq))
            (reverse seq))]
    (if (= seq r)
      true
      false)))
(false? (f1 '(1 2 3 4 5))) ;; => true
(true? (f1 "racecar")) ;; => true
(true? (f1 [:foo :bar :foo])) ;; => true
(true? (f1 '(1 1 3 3 1 1))) ;; => true
(false? (f1 '(:a :b :c))) ;; => true

;; 2
(defn f2 [coll]
  (as-> coll t
    (reverse t) 
      (= coll t)))
(false? (f2 '(1 2 3 4 5))) ;; => true
(true? (f2 "racecar")) ;; => false
(true? (f2 [:foo :bar :foo])) ;; => true
(true? (f2 '(1 1 3 3 1 1))) ;; => true
(false? (f2 '(:a :b :c))) ;; => true
