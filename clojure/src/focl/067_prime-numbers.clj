;; https://www.4clojure.com/problem/67

;; 1
(defn is-prime? [n]
  (->> n inc (range 1)
       (filter #(= 0 (mod n %)))
       count (= 2)))
(is-prime? 5) :=> true
(is-prime? 6) :=> false
(defn f1 [n]
  (take n (filter is-prime? (iterate inc 1))))
(time (f1 5))
:=> '(2 3 5 7 11) "Elapsed time: 0.043375 msecs"
(time (= (f1 2) [2 3]))
:=> true "Elapsed time: 0.105667 msecs"
(= (f1 5) [2 3 5 7 11]) :=> true
(time (= (last (f1 100)) 541))
:=> true "Elapsed time: 15.388292 msecs"

;; 2
(defn f2 [n]
  (let [div (fn [x] (fn [y] (-> (mod x y) zero? not)))
        prime? (fn [x]
                 (->> (range 2 x)
                      (remove (div x))
                      count zero?))]
    (take n (filter prime? (iterate inc 2)))))
(time (= (f2 2) [2 3]))
:=> true "Elapsed time: 0.343375 msecs"
(time (= (f2 5) [2 3 5 7 11]))
:=> true "Elapsed time: 0.088583 msecs"
(time (= (last (f2 100)) 541))
:=> true "Elapsed time: 3.456959 msecs"
