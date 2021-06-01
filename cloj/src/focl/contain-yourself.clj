;; https://www.4clojure.com/problem/47

;; 1
(contains? #{4 5 6} 4) ;; => true
(contains? [1 1 1 1 1] 4)  ;; => true
(contains? {4 :a 2 :b} 4) ;; => true
(not (contains? [1 2 4] 4)) ;; => true
