(dotimes [x 3]
  (prn x))
;; => nil
;; 0
;; 1
;; 2

(defn dotimes' [x f]
  (doseq [y (range x)]
    (f y)))
(dotimes' 3 prn)
;; 0
;; 1
;; 2
