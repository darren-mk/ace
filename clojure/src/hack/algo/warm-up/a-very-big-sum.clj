;; https://www.hackerrank.com/challenges/a-very-big-sum/problem?isFullScreen=true

;; 1
(defn f1 [ar]
  (apply + ar))
(= 5000000015 
   (f1 [1000000001 1000000002 1000000003 1000000004 1000000005])) ;; => true
