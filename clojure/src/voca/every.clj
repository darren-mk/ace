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
(defn every?' [p coll]
  (->> (for [item coll]
         (p item))
       (reduce #(and %1 %2) true)))
;; => #'user/every?-alt-1
(every?' odd? [1 3 5 7])
;; => true
(every?' odd? [1 2 3])
;; => false

(defn every?'' [pred col]
  (reduce (fn [b item]
            (and b (pred item)))
          true col))
(every?'' odd? [1 3 5 7]) ;; => true
(every?'' odd? [1 2 3]) ;; => false

(defn every?''' [pred [x & xs]]
  (cond (nil? x) true
        (false? (pred x)) false
        :else (every?''' pred xs)))
(every?''' odd? [1 3 5 7]) ;; => true
(every?''' odd? [1 2 3]) ;; => false

(defn every?'''' [pred col]
  (reduce (fn [b x] (and b (pred x))) true col))
(every?'''' odd? [1 3 5 7]) ;; => true
(every?'''' odd? [1 2 3]) ;; => false
