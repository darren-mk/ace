((complement <) 3 2) ;; => true
(filter (complement odd?) [1 2 3 4]) ;; => (2 4)
((complement even?) 1) ;; => true
(#(not (even? %)) 1) ;; => true

;; implementation
;; a
(defn complement-a [f]
  (fn [& x] (not (apply f x))))
((complement-a <) 3 2) ;; => true
(filter (complement-a odd?) [1 2 3 4]) ;; => (2 4)
((complement-a even?) 1) ;; => true
(#(not (even? %)) 1) ;; => true
