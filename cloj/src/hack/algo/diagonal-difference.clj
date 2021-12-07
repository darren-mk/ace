;; https://www.hackerrank.com/challenges/diagonal-difference/problem?isFullScreen=true

;; 1
(defn f1 [arr]
  (let [lr (apply + 
                  (map
                   (fn [index arr] (nth arr index))
                   (range (count arr))
                   arr))
        rl (apply + 
                  (map
                   (fn [index arr] (nth arr index))
                   (reverse (range (count arr)))
                   arr))
        diff (- lr rl)
        gap (if (< diff 0) (- 0 diff) diff)]
    gap))
(= 15 (f1 [[11 2 4] [4 5 6] [10 8 -12]])) ;; => true
