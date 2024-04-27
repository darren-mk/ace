;; https://www.hackerrank.com/challenges/kangaroo/problem?isFullScreen=true&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

; Complete the 'kangaroo' function below.
; The function is expected to return a STRING.
; The function accepts following parameters:
;  1. INTEGER x1
;  2. INTEGER v1
;  3. INTEGER x2
;  4. INTEGER v2

(defn kangaroo [x1 v1 x2 v2]
  (if (or (and (< x1 x2) (< v1 v2))
          (and (< x2 x1) (< v2 v1)))
    "NO"
    (loop [a x1
           b x2]
      (cond (= a b) "YES"
            (or (< 100000000 a) (< 100000000 b)) "NO"
            :else (recur (+ a v1) (+ b v2))))))

(kangaroo 4523 8092 9419 8076)

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def first-multiple-input (clojure.string/split (clojure.string/trimr (read-line)) #" "))

(def x1 (Integer/parseInt (nth first-multiple-input 0)))

(def v1 (Integer/parseInt (nth first-multiple-input 1)))

(def x2 (Integer/parseInt (nth first-multiple-input 2)))

(def v2 (Integer/parseInt (nth first-multiple-input 3)))

(def result (kangaroo x1 v1 x2 v2))

(spit fptr (str result "\n") :append true)
