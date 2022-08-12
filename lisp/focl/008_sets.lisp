;; https://4clojure.oxal.org/#/problem/8

;; 1
(defun unique-set (l)
  (remove-duplicates l))
(equal (list :a :b :c :d) (unique-set '(:a :a :b :c :c :c :c :d :d))) ;; T
(equal (list :a :b :c :d) (union (list  :a :b :c) (list :b :c :d))) ;; T
