;; Wraps x in a way such that a reduce
;; will terminate with the value x

;; https://clojuredocs.org/clojure.core/reduced

;; Suppose you want to short-circuit a sum like:
(reduce (fn [acc v] (+ acc v)) 0 (range 10))
:=> 45

;; So that it returns the sum of the integers if less than 100:
(let [f (fn [a v]
          (if (< a 100)
            (+ a v) a))]
  (reduce f 0 (range 10)))
:=> 45

;; So that it returns the sum of the integers if less than 100:
(let [f (fn [a v]
          (println a)
          (if (< a 100)
            (+ a v) (reduced "too big")))]
  (reduce f 0 (range 50)))
:=> ".. 91 105" "too big"
