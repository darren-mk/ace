((constantly 5) "abc") ;; => 5
((constantly "abc") 123) ;; => "abc"

(defn constantly' [v]
  (fn [& _] v))
((constantly' 5) "abc") ;; => 5
((constantly' "abc") 123) ;; => "abc"
(map (constantly' "hello") (range 3)) ;; => ("hello" "hello" "hello")
(update [0 1 2 3] 2 (constantly' 100)) ;; => [0 1 100 3]
