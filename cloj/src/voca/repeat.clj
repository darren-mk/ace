(take 5 (repeat "x"))
;; => ("x" "x" "x" "x" "x")

(repeat 5 "x")
;; => ("x" "x" "x" "x" "x")

(defn repeat-a
  ([x]
   (lazy-seq (cons x (repeat-a x))))
  ([n x]
   (take n (repeat-a x))))
;; => #'user/repeat-a

(take 5 (repeat-a "x"))
;; => ("x" "x" "x" "x" "x")

(repeat-a 5 "x")
;; => ("x" "x" "x" "x" "x")
