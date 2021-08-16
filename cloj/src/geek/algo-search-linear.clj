;; https://www.geeksforgeeks.org/linear-search/

(def arr (into [] (range 1000)))
;; => #'user/arr

(def x (last arr))
;; => #'user/x

x
;; => 999

(defn linear-search [arr x]
  (loop [arr arr
         round 1]
    (if (= (first arr) x)
      round 
      (recur (rest arr) (inc round)))))

(linear-search arr x)
;; => 1000
