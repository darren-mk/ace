;; https://4clojure.oxal.org/#/problem/28

;; Problem 28
;; Write a function which flattens a sequence.
;; (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
;; (= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
;; (= (__ '((((:a))))) '(:a))
;; Special Restrictions : flatten

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

;; 4
;; referred to
;; https://stackoverflow.com/questions/2680864/how-to-remove-nested-parentheses-in-lisp
(defn f4 [l]
  (if (empty? l)
    nil
    (if (coll? (first l))
      (concat (f4 (first l)) (f4 (rest l)))
      (cons (first l) (f4 (rest l))))));; => #'user/f4
(= (f4 '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)) ;; => true
(= (f4 ["a" ["b"] "c"]) '("a" "b" "c")) ;; => true
(= (f4 '((((:a))))) '(:a)) ;; => true
