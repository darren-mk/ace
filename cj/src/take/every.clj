(every? (fn [x] (odd? x)) [1 3 5 7])
;; => true

(every? (fn [x] (odd? x)) [1 3 5 6])
;; => false

(every? odd? [1 3 5 7])
;; => true
