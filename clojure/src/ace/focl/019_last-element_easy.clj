;; https://4clojure.oxal.org/#/problem/19

;; Problem 19
;; Write a function which returns the last element in a sequence.
;; (= (__ [1 2 3 4 5]) 5)
;; (= (__ '(5 4 3)) 3)
;; (= (__ ["b" "c" "d"]) "d")
;; Special Restrictions : last

(defn tester [f]
  (and (= (f [1 2 3 4 5]) 5)
       (= (f '(5 4 3)) 3)
       (= (f ["b" "c" "d"]) "d")))

(defn f1 [coll]
  (nth coll (- (count coll) 1)))

(tester f1)

(defn f2 [coll]
  (-> coll
      reverse
      first))

(tester f2)

(defn f3 [coll]
  (let [m (apply hash-map (interleave (iterate inc 0) coll))
        k (apply max (keys m))]
    (get m k)))

(tester f3)

(defn f4 [coll]
  (-> coll
      reverse
      first))

(tester f4)

(defn f5 [coll]
  (reduce
   (fn [a b] (if (nil? b) a b))
   coll))

(tester f5)

(defn f6 [[x & xs]]
  (if xs (recur xs) x))

(tester f6)

(defn f_g [l]
  (nth l (dec (count l))))

(tester f_g)

(defn f_h [[x & xs]]
  (if-not (seq xs) x (f_h xs)))

(tester f_h)
