;; https://4clojure.oxal.org/#/problem/31

;; Problem 31
;; Write a function which packs consecutive duplicates into sub-lists.
;; (= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
;; (= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
;; (= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))

;; 1
(defn f1 [l]
  (partition-by identity l));; => #'user/f1
(= (f1 [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))) ;; => true
(= (f1 [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))) ;; => true
(= (f1 [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4]))) ;; => true
