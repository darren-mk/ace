;; https://www.geeksforgeeks.org/binary-search/

(def arr (into [] (range 1000)))
;; => #'user/arr

(def x 777)
;; => #'user/x

x
;; => 999

(defn binary-search [arr x]
  (loop [arr arr
         round 1]
    (let [mid-point (int (/ (- (count arr) 1) 2))
          taken-half (if (< x (nth arr mid-point))
                       (take mid-point arr)
                       (take mid-point (reverse arr)))]
      (if (= (first taken-half) x)
        round
        (recur taken-half (inc round))))))
;;;;;;;;;; MOT WORKING - WHY?
(binary-search (range 3) 1)



