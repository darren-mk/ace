(empty? []) ;; => true
(empty? '()) ;; => true
(empty? #{}) ;; => true

(defn empty?-a
  [[x & _]]
  (nil? x))
(empty?-a []) ;; => true
(empty?-a '()) ;; => true
(empty?-a #{}) ;; => true
(empty?-a [1]) ;; => false