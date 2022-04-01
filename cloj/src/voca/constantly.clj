((constantly 5) "abc") ;; => 5
((constantly "abc") 123) ;; => "abc"

;;;; implementation
;; a
(defn constantly-a [v]
  (fn [& _] v))
((constantly-a 5) "abc") ;; => 5
((constantly-a "abc") 123) ;; => "abc"
(map (constantly-a "hello") (range 3)) ;; => ("hello" "hello" "hello")
(update [0 1 2 3] 2 (constantly-a 100)) ;; => [0 1 100 3]
