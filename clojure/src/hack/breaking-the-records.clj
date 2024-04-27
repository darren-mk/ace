;; https://www.hackerrank.com/challenges/breaking-best-and-worst-records

; Complete the 'breakingRecords' function below.
; The function is expected to return an INTEGER_ARRAY.
; The function accepts INTEGER_ARRAY scores as parameter.

(require '[clojure.string :as str])

(defn breakingRecords [scores]
  (loop [scores scores
         min (first scores)
         max (first scores)
         break-min 0
         break-max 0]
    (cond (empty? scores) [break-max break-min]
          (< (first scores) min) (recur (rest scores)
                                        (first scores)
                                        max
                                        (inc break-min)
                                        break-max)
          (< max (first scores)) (recur (rest scores)
                                        min
                                        (first scores)
                                        break-min
                                        (inc break-max))
          :else (recur (rest scores)
                       min
                       max
                       break-min
                       break-max))))

(breakingRecords [10 5 20 20 4 5 2 25 1])
;; => [2 4]

(def fptr
  (get (System/getenv)
       "OUTPUT_PATH"))

(def n
  (Integer/parseInt
   (str/trim
    (read-line))))

(def scores
  (vec (map #(Integer/parseInt %)
            (str/split
             (str/trimr
              (read-line)) #" "))))

(def result
  (breakingRecords scores ))

(spit fptr
      (str/join " " result)
      :append true)

(spit fptr
      "\n"
      :append true)
