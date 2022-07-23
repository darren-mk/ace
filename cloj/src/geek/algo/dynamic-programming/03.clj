;; https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/

(def rec (atom []))
(defn lis [l]
  (loop [l l
         temp (atom [])]
    (cond (empty? l) (do (swap! rec conj (count @temp)) (apply max @rec))
          (and (not-empty l) (empty? @temp)) (do (swap! temp conj (first l))
                                                    (recur (rest l) temp))
          (< (last @temp) (first l)) (do (swap! temp conj (first l))
                                         (recur (rest l) temp))
          :else (do (lis l)
                    (recur (rest l) temp)))))

(time (lis [10 22 9 33 21 50 41 60]))
;; => 5
;; "Elapsed time: 0.41625 msecs"
