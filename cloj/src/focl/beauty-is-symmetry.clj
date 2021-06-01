;; https://www.4clojure.com/problem/96

;; 1
(defn f1 [coll]
  (and (= 3 (count coll))
       (= (second coll) (last coll))
       (if (coll? (second coll)) (f1 (second coll)) true)
       (if (coll? (last coll)) (f1 (last coll)) true)))	
(= (f1 '(:a (:b nil nil) (:b nil nil))) true) ;; => true
(= (f1 '(:a (:b nil nil) nil)) false) ;; => true
(= (f1 '(:a (:b nil nil) (:c nil nil))) false) ;; => true
(= (f1 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
   true) ;; => false
(= (f1 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
   false) ;; => true
(= (f1 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [6 nil nil] nil]] nil]])
   false) ;; => true
