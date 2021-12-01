;; https://www.hackerrank.com/challenges/2d-array/problem?h_r=next-challenge&h_v=zen

;; 1
; Complete the 'hourglassSum' function below.
; The function is expected to return an INTEGER.
; The function accepts 2D_INTEGER_ARRAY arr as parameter.
(defn hourglassSum [arr]
  (loop [i 0]
    (if )

    )
  )

(def arr-ex-1
  [[-9 -9 -9 1 1 1]
   [0 -9 0 4 3 2]
   [-9 -9 -9 1 2 3]
   [0 0 8 6 6 0]
   [0 0 0 -2 0 0]  
   [0 0 1 2 4 0]])
(get-in arr-ex-1 [1 3])

(def fptr
  (get (System/getenv)
       "OUTPUT_PATH"))
(def arr [])
(doseq [_ (range 6)]
  (def arr
    (conj arr
          (vec (map #(Integer/parseInt %)
                    (clojure.string/split
                     (clojure.string/trimr
                      (read-line)) #" "))))))
(def result
  (hourglassSum arr))
(spit fptr
      (str result "\n")
      :append true)
