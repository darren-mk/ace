(butlast [1 2 3 4]) ;; => (1 2 3)
(butlast '(:a "x" 123)) ;; => (:a "x")

;;;; implementation

;; a
(defn butlast' [coll]
  (vals
   (filter #(not= (dec (count coll)) (key %))
           (zipmap (range) coll))))
(butlast' [1 2 3 4]) ;; => (1 2 3)
(butlast' '(:a "x" 123)) ;; => (:a "x")

;; b
(defn butlast'' [coll]
  (if (= 1 (count coll))
    nil
    (cons (first coll) (butlast'' (rest coll)))))
(butlast'' [1 2 3 4]) ;; => (1 2 3)
(butlast'' (list :a "x" 123)) ;; => (:a "x")

(defn butlast'''
  ([col]
   (butlast''' col []))
  ([[x & xs :as col] acc]
   (if (= 1 (count col))
     (seq acc)
     (butlast''' xs (conj acc x)))))
(butlast''' [1 2 3 4]) ;; => (1 2 3)
(butlast''' (list :a "x" 123)) ;; => (:a "x")

(def butlast-4
  (comp reverse rest reverse))
(butlast-4 [1 2 3 4]) ;; => (1 2 3)
(butlast-4 (list :a "x" 123)) ;; => (:a "x")
