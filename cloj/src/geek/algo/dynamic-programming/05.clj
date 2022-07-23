;; https://www.geeksforgeeks.org/edit-distance-dp-5/

(defn edit-a [a b]
  (cond (or (empty? a) (empty? b)) 0
        (= (first a) (first b)) (+ 0 (edit-a (rest a) (rest b)))
        :else (+ 1 (min (edit-a a (rest b)) (edit-a (rest a) b)))))
(time (edit-a "sunday" "saturday"))
;; => 4
;; "Elapsed time: 0.398833 msecs"

(def lookup-b (atom {}))
(defn edit-b [a b]
  (cond (contains? @lookup-b [a b]) (get @lookup-b [a b])
        (or (empty? a) (empty? b)) (do (swap! lookup-b assoc [a b] 0) 0)
        (= (first a) (first b)) (let [v (+ 0 (edit-b (rest a) (rest b)))]
                                  (swap! lookup-b assoc [a b] v) v)
        :else (let [v (+ 1 (min (edit-b a (rest b)) (edit-b (rest a) b)))]
                (swap! lookup-b assoc [a b] v) v)))
(time (edit-b "sunday" "saturday"))
;; => 4
;; "Elapsed time: 0.220292 msecs"
