;; https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/

(defn lcs-a [a b]
  (cond (or (empty? a) (empty? b)) 0
        (= (first a) (first b)) (+ 1 (lcs-a (rest a) (rest b)))
        :else (max (lcs-a a (rest b))
                   (lcs-a (rest a) b))))
(time (lcs-a "AGGTAB" "GXTXAYB"))
;; => 4
;; "Elapsed time: 0.943834 msecs"


(def lookup-b (atom {}))
(defn lcs-b [a b]
  (cond
    ;;
    (contains? @lookup-b [a b])
    (get @lookup-b [a b])
    ;;
    (or (empty? a) (empty? b))
    (do (swap! lookup-b assoc [a b] 0) 0)
    ;;
    (= (first a) (first b))
    (let [v (+ 1 (lcs-b (rest a) (rest b)))]
      (swap! lookup-b assoc [a b] v)
      v)
    ;;
    :else (let [v (max (lcs-b a (rest b)) (lcs-b (rest a) b))]
            (swap! lookup-b assoc [a b] v)
            v)))

(time (lcs-b "AGGTAB" "GXTXAYB"))
;; => 4
;; "Elapsed time: 0.943834 msecs"
