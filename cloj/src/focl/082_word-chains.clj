;; https://4clojure.oxal.org/#/problem/82

(require '[clojure.set :as cs])

;; 1
(defn compare-two-same-length [x y]
  (let [xs (seq (char-array x))
        ys (seq (char-array y))]
    (->> (map (fn [a b] [a b]) xs ys)
         (filter (fn [pair] (not= (first pair) (last pair))))
         count
         (>= 1))))
(defn compare-different-length [x y]
  (let [longer (set (char-array (if (< (count x) (count y)) y x)))
        shorter (set (char-array (if (< (count x) (count y)) x y)))
        diff (cs/difference longer shorter)
        same (cs/intersection longer shorter)]
    (and (= 1 (count diff))
         (= shorter same))))
(compare-different-length "abc" "aqbc")
(set (char-array "abc"))
(compare-two-same-length "abc" "bbc")

(clojure.string/split "" "abc")
(defn compare-two [x y]
  (if (= (count x) (count y))
    (compare-two-same-length x y)
    (compare-different-length x y)))

(defn f1 [coll]
  (if (empty? coll)
    true
    (let [comparee (first coll)
          comparers (rest coll)]
      (reduce (fn [a x] (compare-two ))))
    )
  )
(= true (f1 #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}))
(= false (f1 #{"cot" "hot" "bat" "fat"}))
(= false (f1 #{"to" "top" "stop" "tops" "toss"}))
(= true (f1 #{"spout" "do" "pot" "pout" "spot" "dot"}))
(= true (f1 #{"share" "hares" "shares" "hare" "are"}))
(= false (f1 #{"share" "hares" "hare" "are"}))
