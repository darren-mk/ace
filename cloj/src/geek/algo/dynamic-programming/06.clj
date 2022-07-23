
(defn min-cost
  [m a b]
  (if (or (< a 0) (< b 0))
    0
    (+ (get m [a b])
       (min (min-cost m a (dec b))
            (min-cost m (dec a) b)
            (min-cost m (dec a) (dec b))))))

(def sample-matrix
  {[0 0] 1
   [0 1] 2
   [0 2] 3
   [1 0] 4
   [1 1] 8
   [1 2] 2
   [2 0] 1
   [2 1] 5
   [2 2] 3})

(min-cost sample-matrix 2 2)

#_
[[1, 2, 3],
 [4, 8, 2],
 [1, 5, 3]]
