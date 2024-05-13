;; https://www.hackerrank.com/challenges/mini-max-sum

;; 1
(defn f1 [arr]
  (let [sorted (sort arr)
        mx (apply + (drop 1 sorted))
        mn (apply + (drop 1 (reverse sorted)))]
    (println mn mx)))
(f1 [1 2 3 4 5]) ;; 10 14
