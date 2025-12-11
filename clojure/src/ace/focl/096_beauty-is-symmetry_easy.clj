;; https://4clojure.oxal.org/#/problem/96

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

;; 2
(defn f2 [l]
  (if (= 3 (count l))
    (cond (and (not (coll? (second l)))
               (not (coll? (last l)))) (= (second l) (last l))
          (and (coll? (second l))
               (coll? (last l))) (and (= (first (second l)) (first (last l)))
                                      (= (f2 (second l)) (f2 (last l))))
          :else false)
    false))
(= (f2 '(:a (:b nil nil) (:b nil nil))) true) ;; => true
(= (f2 '(:a (:b nil nil) nil)) false) ;; => true
(= (f2 '(:a (:b nil nil) (:c nil nil))) false)
(= (f2 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
   true) ;; => true
(= (f2 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
   false) ;; => false
(= (f2 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [6 nil nil] nil]] nil]])
   false) ;; => false

;; 3
;; https://4clojure.oxal.org/#/problem/96/solutions
(defn f3 [[_ l r]]
  (= l
     ((fn f [[a b c]]
        (when a [a (f c) (f b)]))
      r)))
(= (f3 '(:a (:b nil nil) (:b nil nil))) true) ;; => true
(= (f3 '(:a (:b nil nil) nil)) false) ;; => true
(= (f3 '(:a (:b nil nil) (:c nil nil))) false) ;; => true
(= (f3 [1
        [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
   true) ;; => true
(= (f3 [1
        [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
   false) ;; => true
(= (f3 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [6 nil nil] nil]] nil]])
   false) ;; => true
