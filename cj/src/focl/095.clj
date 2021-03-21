;; https://www.4clojure.com/problem/95

;; 1
(defn f1 [coll]
  (and (= 3 (count coll))
       (if (coll? (second coll))
         (f1 (second coll)) true)
       (if (coll? (last coll))
         (f1 (last coll)) true)))
(= (f1 '(:a (:b nil nil) nil)) true) ;; => true
(= (f1 '(:a (:b nil nil))) false) ;; => true
(= (f1 [1 nil [2 [3 nil nil] [4 nil nil]]]) true) ;; => true
(= (f1 [1 [2 nil nil] [3 nil nil] [4 nil nil]]) false) ;; => true
(= (f1 [1 [2 [3 [4 nil nil] nil] nil] nil]) true) ;; => true
(= (f1 [1 [2 [3 [4 false nil] nil] nil] nil]) false) ;; => false
(= (f1 '(:a nil ())) false) ;; => true
