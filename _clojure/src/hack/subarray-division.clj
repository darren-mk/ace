;; https://www.hackerrank.com/challenges/the-birthday-bar

; Complete the 'birthday' function below.
; The function is expected to return an INTEGER.
; The function accepts following parameters:
;  1. INTEGER_ARRAY s
;  2. INTEGER d
;  3. INTEGER m

(require '[clojure.string])

(defn birthday [s d m]
  (loop [r 0
         s s]
    (cond (< (count s) m) r
          (= d (apply + (take m s))) (recur (inc r) (rest s))
          :else (recur r (rest s)))))

(birthday  [1 2 1 3 2] 3 2)
;; => 2

(def fptr
  (get (System/getenv) "OUTPUT_PATH"))

(def n
  (Integer/parseInt
   (clojure.string/trim
    (read-line))))

(def s
  (vec (map #(Integer/parseInt %)
            (clojure.string/split
             (clojure.string/trimr
              (read-line)) #" "))))

(def first-multiple-input
  (clojure.string/split
   (clojure.string/trimr
    (read-line)) #" "))

(def d
  (Integer/parseInt
   (nth first-multiple-input 0)))

(def m
  (Integer/parseInt
   (nth first-multiple-input 1)))

(def result (birthday s d m))

(spit fptr (str result "\n") :append true)
