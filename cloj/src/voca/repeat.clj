(take 5 (repeat "x"))
:=> '("x" "x" "x" "x" "x")

(repeat 5 "x")
:=> '("x" "x" "x" "x" "x")

(defn repeat'
  ([x]
   (lazy-seq (cons x (repeat' x))))
  ([n x]
   (take n (repeat' x))))
:=> "#'user/repeat-a"

(take 5 (repeat' "x"))
:=> '("x" "x" "x" "x" "x")

(repeat' 5 "x")
:=> '("x" "x" "x" "x" "x")

(defn repeat'' [n x]
  (lazy-seq
   (let [f (fn [a _] (cons x a))]
     (reduce f '() (range n)))))

(take 2 (repeat'' 4 :x))
:=> '(:x :x)

(time (repeat'' 100000 :x))
"Elapsed time: 0.375791 msecs"
