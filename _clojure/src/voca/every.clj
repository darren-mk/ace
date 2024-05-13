(every? (fn [x] (odd? x)) [1 3 5 7])
;; => true

(every? (fn [x] (odd? x)) [1 3 5 6])
;; => false

(every? odd? [1 3 5 7])
;; => true

(every? true? [true true])
;; => true

(every? true? [true false])
;; => false

;; implementation 1
(defn every?-alt-1 [p coll]
  (->> (for [item coll]
         (p item))
       (reduce #(and %1 %2) true)))
;; => #'user/every?-alt-1
(every?-alt-1 odd? [1 3 5 7])
;; => true
(every?-alt-1 odd? [1 2 3])
;; => false
