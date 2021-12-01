;; https://www.hackerrank.com/challenges/simple-array-sum/problem?isFullScreen=true

;; 1
(defn f1 [ar]
  (apply + ar))
(f1 1 2 3 4 10 11)


;; 2
(defn f2 [ar]
    (reduce + 0 ar))
