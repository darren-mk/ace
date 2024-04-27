(dotimes [x 3]
  (prn x))
;; => nil
;; 0
;; 1
;; 2

(defn dotimes-f-a [x f]
  (doseq [y (range x)]
    (f y)))
(dotimes-f-a 3 prn)
;; 0
;; 1
;; 2
