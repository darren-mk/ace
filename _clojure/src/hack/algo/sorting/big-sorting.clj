;; https://www.hackerrank.com/challenges/big-sorting

;; 1
(defn f1 [unsorted]
  (sort
   (map read-string unsorted)))
(f1 ["31415926535897932384626433832795" "1" "3" "10" "3" "5"])
;; time limit exceeded

;; 2
(defn comp-fn [s1 s2]
  (let [c (compare (count s1) (count s2))]
    (if (zero? c)
      (compare s1 s2)
      c)))
(defn f2 [unsorted]
  (sort comp-fn unsorted))
(f2 ["31415926535897932384626433832795" "1" "3" "10" "3" "5"])
;; success

;; 3
(defn f3 [unsorted]
  (let [comparator (fn [a b]
                     (let [by-length (compare (count a) (count b))]
                       (if (zero? by-length)
                           (compare a b)
                           by-length)))]
    (sort comparator unsorted)))
(f3 ["31415926535897932384626433832795" "1" "3" "10" "3" "5"])
;; success
