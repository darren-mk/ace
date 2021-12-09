;; https://www.hackerrank.com/challenges/coin-change

;; 1
(defn f1 [n arr dyn]
  (let [dyn-sum (apply + dyn)]
    (cond
      (= n dyn-sum) dyn
      (< n dyn-sum) nil
      (> n dyn-sum) (for [i arr]
                      (flatten (f1 n arr (conj dyn i))))
     )))
(f1 3 [8 3 1 2] [])


(contains? [1 2 3] 3)
(contains? #{1 2 3} 3)


(defn fh1 [words]
  (let [unique-chars-and-count (map (fn [word] [(into #{} word)
                                      (count word)]) words)
        unique-words (into #{} unique-chars-and-count)
        num-groups (count unique-words)]
    num-groups))

(empty? #{})

(fh1 ["" "b"])

(fh1 ["inch" "cat" "chin" "kit" "act"])
(fh1 ["cat" "listen" "silent" "kitten" "salient"])
(fh1 ["pat" "tap" "apt" "bat"])
(fh1 ["cloth" "loath" "pillow"])
(fh1 ["cat" "chin" "kit" "act"])


(defn fff [stocksProfit target]
  (let [indices (range (count stocksProfit))
        indexed-profit (zipmap indices stocksProfit)
        pairs (->> (for [i indices
                         j indices]
                    (when (and (not= i j)
                               (= target (+ (nth stocksProfit i)
                                            (nth stocksProfit j))))
                      [(nth stocksProfit i)
                       (nth stocksProfit j)]))
                   (filter #(not= nil %))
                   (map #(into #{} %)))
        unique-pairs (into #{} pairs)
        num-unique-pairs (count unique-pairs)]
    pairs))
(fff [1 3 46 1 3 9] 47)
(fff [6 6 3 9 3 5 1] 12)



(defn stockPairs [stocksProfit target]
  (->> (for [i (range (count stocksProfit))
             j (range (count stocksProfit))]
           (when (and
                  (= target (+ (nth stocksProfit i)
                               (nth stocksProfit j)))
                  (not= i j))
             [(nth stocksProfit i)
              (nth stocksProfit j)]))
        (filter #(not= % nil))
        (map #(into #{} %))
        (into #{})
        count)
  )

(stockPairs [6 12 3 9 3 5 1] 12)
(stockPairs [1 3 46 1 3 9] 47)
(stockPairs [6 6 3 9 3 5 1] 12)

(def v ["one" "two" "three" "two"])
 (.indexOf v "two")
