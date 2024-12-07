;; https://www.hackerrank.com/challenges/divisible-sum-pairs

; Complete the 'divisibleSumPairs' function below.
; The function is expected to return an INTEGER.
; The function accepts following parameters:
;  1. INTEGER n
;  2. INTEGER k
;  3. INTEGER_ARRAY ar

(require '[clojure.string])


(defn divisibleSumPairs [n k ar]
  
  
  )

(divisibleSumPairs 6 3 [1 3 2 6 1 2])


(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def first-multiple-input (clojure.string/split (clojure.string/trimr (read-line)) #" "))

(def n (Integer/parseInt (nth first-multiple-input 0)))

(def k (Integer/parseInt (nth first-multiple-input 1)))

(def ar (vec (map #(Integer/parseInt %) (clojure.string/split (clojure.string/trimr (read-line)) #" "))))

(def result (divisibleSumPairs n k ar))

(spit fptr (str result "\n") :append true)
