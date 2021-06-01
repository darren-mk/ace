;; https://www.4clojure.com/problem/28

;; 1
;; referred to
;; https://github.com/qiuxiafei/4clojure/blob/master/answers/28.Flatten%20a%20Sequence
(defn f1 [sq]
  (filter (fn [x] ((complement sequential?) x)) 
          (tree-seq sequential? identity sq)))
(= (f1 '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)) ;; => true
(= (f1 ["a" ["b"] "c"]) '("a" "b" "c")) ;; => true
(= (f1 '((((:a))))) '(:a)) ;; => true

;; 2
(defn f2 [sq]
  (filter (complement sequential?) 
          (tree-seq sequential? identity sq)))
(= (f2 '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)) ;; => true
(= (f2 ["a" ["b"] "c"]) '("a" "b" "c")) ;; => true
(= (f2 '((((:a))))) '(:a)) ;; => true

;; 3
(defn f3 [coll]
  (->> coll
       (tree-seq sequential? identity)
       (filter (complement sequential?))))
(= (f3 '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)) ;; => true
(= (f3 ["a" ["b"] "c"]) '("a" "b" "c")) ;; => true
(= (f3 '((((:a))))) '(:a)) ;; => true
