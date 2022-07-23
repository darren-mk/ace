;; https://www.geeksforgeeks.org/overlapping-subproblems-property-in-dynamic-programming-dp-1/

(defn fibonacci-a [x]
  (if (<= x 1)
    x
    (+ (fibonacci-a (- x 1))
       (fibonacci-a (- x 2)))))
;; test
(time (fibonacci-a 30))
;; => 832040
;; "Elapsed time: 13.408 msecs"

(def look-up (atom {}))
(defn fibonacci-b [x]
  (let [stored (get @look-up x)]
    (cond (<= x 1) x
          stored stored
          :else (let [new (+ (fibonacci-b (- x 1)) (fibonacci-b (- x 2)))]
                  (swap! look-up assoc x new)
                  (prn "@@@@" @look-up)
                  new))))
;; test
(time (fibonacci-b 30))
;; => 832040
;; "Elapsed time: 0.412125 msecs"

(def fibonacci-memoized
  (memoize (fn [x]
             (if (<= x 1)
               x
               (+ (fibonacci-memoized (- x 1))
                  (fibonacci-memoized (- x 2)))))))
;; test
(time (fibonacci-memoized 30))
;; => 832040
;; "Elapsed time: 0.079375 msecs"
