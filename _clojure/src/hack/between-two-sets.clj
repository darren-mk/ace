;; https://www.hackerrank.com/challenges/between-two-sets

; Complete the 'getTotalX' function below.
; The function is expected to return an INTEGER.
; The function accepts following parameters:
;  1. INTEGER_ARRAY a
;  2. INTEGER_ARRAY b

(defn all-divided-evenly [x divisors]
  (every?
   #(zero? (mod x %)) 
   divisors))

(defn all-divides-evenly [x divisors]
  (every?
   #(zero? (mod % x))
   divisors))

(defn getTotalX [a b]
  (let [candidates-1 (drop (last a) (range (inc (first b))))
        candidates-2 (filter #(all-divided-evenly % a) candidates-1)
        candidates-3 (filter #(all-divides-evenly % b) candidates-2)]
    (count candidates-3)))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def first-multiple-input
  (clojure.string/split
   (clojure.string/trimr (read-line))
   #" "))

(def n
  (Integer/parseInt
   (nth first-multiple-input 0)))

(def m
  (Integer/parseInt
   (nth first-multiple-input 1)))

(def arr
  (vec (map #(Integer/parseInt %)
            (clojure.string/split
             (clojure.string/trimr (read-line))
             #" "))))

(def brr
  (vec (map #(Integer/parseInt %)
            (clojure.string/split
             (clojure.string/trimr (read-line))
             #" "))))

(def total (getTotalX arr brr))

(spit fptr (str total "\n") :append true)
