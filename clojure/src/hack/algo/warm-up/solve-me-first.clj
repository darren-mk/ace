;; https://www.hackerrank.com/challenges/solve-me-first/problem

;; 1
(let [a (read-line)
      b (read-line)
      r (->> [a b]  
             (map read-string)
             (apply +))]
  (prn r))
