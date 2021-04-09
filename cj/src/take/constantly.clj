(comment
  (defn constantly
    "Returns a function that takes any number of arguments and returns x."
    {:added "1.0"
     :static true}
    [x] (fn [& args] x)))

((constantly 5) "abc")
;; => 5

((constantly "abc") 123)
;; => "abc"

(defn constantly-2 [x]
  (fn [& _] x))

((constantly-2 5) "abc")
;; => 5

((constantly-2 "abc") 123)
;; => "abc "

(map (constantly "hello") (range 3))
;; => ("hello" "hello" "hello")

(update [0 1 2 3] 2 (constantly 100))
;; => [0 1 100 3]
