(ns ace.focl.p122
  (:require
   [clojure.test :as t]))

;; Write a function which converts a binary number (given as a string) to a number.

(defn run [f]
  (and (= 0 (f "0"))
       (= 7 (f "111"))
       (= 8 (f "1000"))
       (= 9 (f "1001"))
       (= 255 (f "11111111"))
       (= 1365 (f "10101010101"))
       (= 65535 (f "1111111111111111"))))

(defn a [s]
  (Integer/parseInt s 2))

(defn b [s]
  (reduce (fn [v m] (+ v (* (first m) (second m))))
          0
          (partition
           2
           (interleave
            (reverse (map #(Integer/parseInt %)
                          (map str (char-array s))))
            (iterate #(* 2 %) 1)))))

(defn c [s]
  (let [parse #(Integer/parseInt %)
        digits (->> s char-array (map str)
                    (map parse) reverse)
        powers (iterate (fn [x] (* x 2)) 1)]
    (apply + (map * digits powers))))

(t/deftest all
  (t/are [f] (run f)
    a b c))
