;; https://www.hackerrank.com/challenges/staircase/problem?isFullScreen=true&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

;; 1
(defn f1 [n]
  (let [f (fn stair [x]
                (if (<= x 0)
                  ""  
                  (str "#" (stair (dec x)))))]
    (doseq [i (range 1 (inc n))]
      (println (f i))))) ;; STILL WORKING

(f1 4)
