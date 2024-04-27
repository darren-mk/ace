;; https://www.4clojure.com/problem/48

;; Problem 48
;; The some function takes a predicate function and a collection.
;; It returns the first logical true value of (predicate x)
;; where x is an item in the collection.
;; (= __ (some #{2 7 6} [5 6 7 8]))
;; (= __ (some #(when (even? %) %) [5 6 7 8]))

;; 1
(= 6 (some #{2 7 6} [5 6 7 8])) ;; => true
(= 6 (some #(when (even? %) %) [5 6 7 8])) ;; => true

;; 2
(defn f2 [f l]
  (first (filter f l))) ;; => #'user/f2
(= 6 (f2 #{2 7 6} [5 6 7 8])) ;; => true
(= 6 (f2 #(when (even? %) %) [5 6 7 8])) ;; => true
