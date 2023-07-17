(interleave [1 2 3] [4 5 6]) ;; => (1 4 2 5 3 6)
(interleave '(1 2 3) [7 8 9]) ;; => (1 7 2 8 3 9)
(interleave [:a :b] [1 2 3]) ;; => (:a 1 :b 2)
(interleave [:a :b] [1 2]) ;; => (:a 1 :b 2)
(interleave [:a :b] [1 2 3]) ;; => (:a 1 :b 2)
(interleave [:a :b] [1]) ;; => (:a 1)
(interleave ["i" "in"] ["am" "love"]) ;; => ("i" "am" "in" "love")
(zipmap [:a :b] [1 2 3]) ;; => {:a 1, :b 2}
(zipmap [:a :b] [1]) ;; => {:a 1}

(defn interleave-a [a b]
  (flatten (map (fn [x y] [x y]) a b)))
(interleave-a [1 2 3] [4 5 6]) ;; => (1 4 2 5 3 6)
(interleave-a '(1 2 3) [7 8 9]) ;; => (1 7 2 8 3 9)
(interleave-a [:a :b] [1 2 3]) ;; => (:a 1 :b 2)
(interleave-a [:a :b] [1 2]) ;; => (:a 1 :b 2)

(defn interleave-b [a b]
  (loop [a a b b result []]
    (if (or (empty? a) (empty? b)) result
        (recur (rest a) (rest b)
               (concat result [(first a) (first b)])))))
(interleave-b [1 2 3] [4 5 6]) ;; => (1 4 2 5 3 6)
(interleave-b '(1 2 3) [7 8 9]) ;; => (1 7 2 8 3 9)
(interleave-b [:a :b] [1 2 3]) ;; => (:a 1 :b 2)
(interleave-b [:a :b] [1 2]) ;; => (:a 1 :b 2)
