;; Returns a lazy seq of the first item
;; in each coll, then the second etc.

(interleave [1 2 3] [4 5 6]) :=> '(1 4 2 5 3 6)
(interleave '(1 2 3) [7 8 9]) :=> '(1 7 2 8 3 9)
(interleave [:a :b] [1 2 3]) :=> '(:a 1 :b 2)
(interleave [:a :b] [1 2]) :=> '(:a 1 :b 2)
(interleave [:a :b] [1 2 3]) :=> '(:a 1 :b 2)
(interleave [:a :b] [1]) :=> '(:a 1)
(interleave ["i" "in"] ["am" "love"]) :=> '("i" "am" "in" "love")
(zipmap [:a :b] [1 2 3]) :=> {:a 1, :b 2}
(zipmap [:a :b] [1]) :=> {:a 1}

(defn interleave' [a b]
  (flatten (map (fn [x y] [x y]) a b)))
(interleave' [1 2 3] [4 5 6]) :=> '(1 4 2 5 3 6)
(interleave' '(1 2 3) [7 8 9]) :=> '(1 7 2 8 3 9)
(interleave' [:a :b] [1 2 3]) :=> '(:a 1 :b 2)
(interleave' [:a :b] [1 2]) :=> '(:a 1 :b 2)
(time (interleave' (range 100) (range 100)))
"Elapsed time: 0.216625 msecs"
"Elapsed time: 0.155166 msecs"
"Elapsed time: 0.195833 msecs"

(defn interleave'' [a b]
  (loop [a a b b result []]
    (if (or (empty? a) (empty? b)) result
        (recur (rest a) (rest b)
               (concat result [(first a) (first b)])))))
(interleave'' [1 2 3] [4 5 6]) :=> '(1 4 2 5 3 6)
(interleave'' '(1 2 3) [7 8 9]) :=> '(1 7 2 8 3 9)
(interleave'' [:a :b] [1 2 3]) :=> '(:a 1 :b 2)
(interleave'' [:a :b] [1 2]) :=> '(:a 1 :b 2)

(defn interleave''' [a b]
  (lazy-seq (flatten (map (fn [x y] [x y]) a b))))
(interleave''' [1 2 3] [4 5 6]) :=> '(1 4 2 5 3 6)
(interleave''' '(1 2 3) [7 8 9]) :=> '(1 7 2 8 3 9)
(interleave''' [:a :b] [1 2 3]) :=> '(:a 1 :b 2)
(interleave''' [:a :b] [1 2]) :=> '(:a 1 :b 2)

(time (interleave''' (range 100) (range 100)))
"Elapsed time: 0.166458 msecs"
"Elapsed time: 0.16375 msecs"
"Elapsed time: 0.181042 msecs"

(defn interleave-4
  ([a b]
   (interleave-4 [] a b))
  ([acc [a & as] [b & bs]]
   (if-not (and a b) acc
           (interleave-4
            (concat acc [a b])
            as bs))))
(interleave-4 [1 2 3] [4 5 6]) :=> '(1 4 2 5 3 6)
(interleave-4 '(1 2 3) [7 8 9]) :=> '(1 7 2 8 3 9)
(interleave-4 [:a :b] [1 2 3]) :=> '(:a 1 :b 2)
(interleave-4 [:a :b] [1 2]) :=> '(:a 1 :b 2)
